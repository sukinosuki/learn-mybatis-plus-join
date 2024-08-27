package com.example.learnmybatisplusjoin.modules.user

import com.example.learnmybatisplusjoin.entity.*
import com.example.learnmybatisplusjoin.mapper.UserMapper
import com.github.yulichang.toolkit.KtWrappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
                tBook
                    .id(Book::id)
                    .result(Book::name)
                    .result(Book::categoryId)
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

        val list = userMapper.selectJoinList(User::class.java, wrapper)

        return list
    }
}