package com.example.learnmybatisplusjoin.modules.user

import com.example.learnmybatisplusjoin.entity.*
import com.example.learnmybatisplusjoin.modules.user.form.FormGet
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user")
class UserController {

//    val logger by lazy {
//        LoggerFactory.getLogger(UserController::class.java)
//    }

    @Autowired
    lateinit var userService: UserService

    @GetMapping("/{id}/book")
    fun getUserBook(@PathVariable("id") id: Long): MutableList<Book> {

        val books = userService.getUserBookById(id)
        return books
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id: Long): User {
        val user = userService.getById(id)

        return user
    }

    // http://localhost:8080/api/v1/user?page1=&size=10&order=asc
    @GetMapping
    fun get(query: FormGet): MutableList<User>? {
        val list = userService.getUser(query)

        return list
    }
}