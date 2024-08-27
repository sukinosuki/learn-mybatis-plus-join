package com.example.learnmybatisplusjoin.modules.user

import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.example.learnmybatisplusjoin.entity.*
import com.example.learnmybatisplusjoin.mapper.UserMapper
import com.github.yulichang.kt.KtLambdaWrapper
import com.github.yulichang.toolkit.KtWrappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.function.Consumer

@RestController
@RequestMapping("/api/v1/user")
class UserController {


//    @Autowired
//    lateinit var userRepository: UserRepository

    @Autowired
    lateinit var userMapper: UserMapper

//    @GetMapping("/{id}")
//    fun getById(@RequestParam("id") id: Long) {
//
//        KtWrappers.query(User::class.java)
//            .selectAll(User::class.java)
//            .selectCollection(Role::class.java) { tRole->
//                tRole.
//            }
//    }

    @GetMapping
    fun get(): MutableList<User>? {

//        val list = userRepository.findAll()
//
//        return list

//        val wrapper = KtWrappers
//            .query(User::class.java)
//            .select(User::id, User::name)
//            .selectAssociation(UserIdCard::class.java, User::userIdCard)
//            .leftJoin(UserIdCard::class.java, UserIdCard::uid, User::id)
//
//        val list = userMapper.selectJoinList(User::class.java, wrapper)

        //
        val wrapper = KtWrappers
            .query(User::class.java)
            .selectAll(User::class.java)
            // 一对一查询 userIdCard
            .selectAssociation(UserIdCard::class.java, User::userIdCard)
            // 一对多查询 books
            .selectCollection(User::books) { tBook ->
                // 如果是嵌套查询如 user-book-user, book再查user时，需要指定一个额外left join别名(这里是user_for_book)
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
            .leftJoin(User::class.java, "user_for_book", User::id, Book::uid) // 这里是单独为 .association("user_for_book", User::class.java, Book::user)嵌套查询的left join, 定义的alias要对应

        val list = userMapper.selectJoinList(User::class.java, wrapper)

        return list
    }
}