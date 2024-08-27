package com.example.learnmybatisplusjoin.modules.user

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.learnmybatisplusjoin.entity.*
import com.example.learnmybatisplusjoin.mapper.UserMapper
import com.example.learnmybatisplusjoin.modules.user.form.FormGet
import com.github.yulichang.toolkit.KtWrappers
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController {

    val logger by lazy {
        LoggerFactory.getLogger(UserController::class.java)
    }

    @Autowired
    lateinit var userMapper: UserMapper

    // http://localhost:8080/api/v1/user?page1=&size=10&order=asc
    @GetMapping
    fun get(query: FormGet): MutableList<User>? {

        // selectJoinList分页会有问题, 先为主表分页
        // TODO: 怎么根据其它表的条件来实现筛选主表, 比如搜索拥有book两本以上的用户, 绑定了userIdCard的用户, 拥有某个角色/权限的用户
        val idList = userMapper
            .selectPage(
                Page(query.page ?: 1, query.size ?: 10),
                KtWrappers.query(User::class.java).select(User::id)
                    .orderBy(true, query.order == "asc", User::id)
            )
            .records.map { it.id }

        //
        val wrapper = KtWrappers
            .query(User::class.java)
            .selectAll(User::class.java)
            // 一对一查询 userIdCard
            .selectAssociation(UserIdCard::class.java, User::userIdCard)
            // 一对多查询 books
            .selectCollection(User::books) { tBook ->
                // 如果是嵌套查询如 user-book-user, book再查user时，需要指定一个额外left join别名(这里是user_for_book, 也可以为t1, t2, t3...按.leftJoin顺序次数)
                tBook.association("user_for_book", User::class.java, Book::user)
            }
            // 多对多查询 role
            .selectCollection(User::roles) { tRole ->
                // role 多对多查询 permission
                tRole.collection(Permission::class.java, Role::permissions)
            }
            // 多对多查询 permission
            .selectCollection(Permission::class.java, User::permissions)

            .leftJoin(UserIdCard::class.java, UserIdCard::uid, User::id)
            .leftJoin(Book::class.java, Book::uid, User::id)
            .leftJoin(User2Role::class.java, User2Role::userId, User::id)
            .leftJoin(Role::class.java, Role::id, User2Role::roleId)
            .leftJoin(Role2Permission::class.java, Role2Permission::roleId, User2Role::roleId)
            .leftJoin(Permission::class.java, Permission::id, Role2Permission::permissionId)
            // 这里是单独为 .association("user_for_book", User::class.java, Book::user)嵌套查询的left join, 定义的alias要对应
            .leftJoin(User::class.java, "user_for_book", User::id, Book::uid)
            .`in`(User::id, idList)
            .orderBy(true, query.order == "asc", User::id)
            .orderByDesc(Permission::id, Book::id)

        val list = userMapper.selectJoinList(User::class.java, wrapper)

        return list
    }
}