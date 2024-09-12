package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableName
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

@TableName("class")
data class Clazz(
    val id: Long = 0,

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    val name: String = "",

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,

    @TableField(exist = false)
    val users: ArrayList<User> = arrayListOf()
)
