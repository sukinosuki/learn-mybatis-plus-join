package com.example.learnmybatisplusjoin.entity

import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class UserIdCard(
    val id: Long = 0,

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val uid: Long = 0,

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    val cardNumber: String = "",

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,
)