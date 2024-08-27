package com.example.learnmybatisplusjoin.modules.user_id_card

import com.example.learnmybatisplusjoin.entity.UserIdCard
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/user-id-card")
class UserIdCardController {


//    @Autowired
//    lateinit var userIdCardRepository: UserIdCardRepository

//    @GetMapping
//    fun get(): MutableList<UserIdCard> {

//        val list = userIdCardRepository.findAll()

//        return list
//    }
}