package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.TableField
import java.time.LocalDateTime

data class BookCategory(
    val id: Long = 0,

    val name: String = "",

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,

    @TableField(exist = false)
    val books: ArrayList<Book> = arrayListOf()
)