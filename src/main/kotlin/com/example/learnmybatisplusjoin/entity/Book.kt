package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.TableField
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class Book(

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val id: Long = 0,

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val name: String = "",

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val uid: Long = 0,

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val author: String = "",

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val categoryId: Long = 0,

    @TableField(exist = false)
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val category: BookCategory? = null,

    @TableField(exist = false)
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val user: User? = null,

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val createdAt: LocalDateTime? = null,

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val updatedAt: LocalDateTime? = null,

    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val deletedAt: LocalDateTime? = null,

)
