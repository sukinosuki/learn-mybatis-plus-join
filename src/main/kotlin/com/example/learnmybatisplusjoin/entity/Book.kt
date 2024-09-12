package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableField
import com.baomidou.mybatisplus.annotation.TableId
import com.example.learnmybatisplusjoin.common.JsonValueNegativeFilter
import com.fasterxml.jackson.annotation.JsonInclude
import java.time.LocalDateTime

data class Book(

    @TableId(type = IdType.AUTO)
    var id: Long = 0,

    // 需要考虑即使是空字符时也要返回给前端问题
    // json忽略空字符串
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    val name: String = "",

    // 因为数据库存的book.uid是一定(也必须)不等于0的, 所以可以设置NON_DEFAULT在uid为0(即查询时忽略uid字段)时不json序列化忽略该字段
    @JsonInclude(value = JsonInclude.Include.NON_DEFAULT)
    val uid: Long = 0,

    // 因为数据库存的book.author是一定(也必须)不等于“”的, 所以可以设置NON_EMPTY在author为“”(即查询时忽略author字段)时不json序列化忽略该字段
    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    val author: String = "",

    // 需要考虑即使是负数时也要返回给前端问题
    // json忽略负数
    // 这里举例在一些字段值为0时也要返回给前端的情况
    @JsonInclude(value = JsonInclude.Include.CUSTOM, valueFilter = JsonValueNegativeFilter::class)
    val categoryId: Long = -1,

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,

    @TableField(exist = false)
    val category: BookCategory? = null,

    @TableField(exist = false)
    val user: User? = null,
)
