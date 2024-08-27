package com.example.learnmybatisplusjoin.dto

import com.example.learnmybatisplusjoin.entity.User
import com.example.learnmybatisplusjoin.entity.UserIdCard
import java.time.LocalDateTime

data class ClazzDto(
    val id: Long = 0,
    val name: String = "",
    val createdAt: LocalDateTime? = null,
    var users: ArrayList<User> = arrayListOf()
)
//data class ClazzDtoUser(
//    val id: Long = 0,
//    val name: String = "",
//
//    val userIdCard: UserIdCard?= null
//)
//
