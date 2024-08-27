package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.TableField
import java.time.LocalDateTime

data class User(
    // @JsonInclude 实现响应不返回特定空值(空字符、空数组、null、0、false?)
    // 有时候一个表的字段太多了, 有些字段是后端业务逻辑需要但是前端又不需要, 只返回需要的字段
    // 后端业务查询user表时只查了id、name字段时, 其它字段为数据类设置的默认值, 如果返回一大堆无意义的字段给前端, 前端找个字段也得找半天

    // 需要注意点:
    // 1. 后端业务查询业务所需字段, 不返回多余的字段给前端(传输问题和前端使用时一大堆字段不好找)
    // 2. 前端使用前需要判断, 比如调用user.userIdCard, userIdCard是用户绑定了id card时才有值，否则是null值(当然也可以在数组类设置空对象默认值, 这样就要使用另外的方式判断了比如user.userIdCard.id == null)，所以使用前需要做一次判空
    // 3. 有时候同一个模型类 a接口不想返回0、""、false这些空值字段(避免接口响应出现太多无意义使用不到字段), 但有时候b接口又需要返回这些空值, 比如枚举值status:0, enabled:false。要怎么实现?
    // 4. 后端业务在优化查询只查询某些特定字段时，比如只查询了id和name，但是后面又直接使用classId字段, 因为数据类设置了默认值0, 所以使用时不会有null问题, 这样直接使用就和数据库的class字段值对应不上了. 需要注意这点
    val id: Long = 0,

    val name: String = "",

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,

    val age: Long = 0,

    val classId: Long = 0,

    @TableField(exist = false)
    val userIdCard: UserIdCard? = null,

    @TableField(exist = false)
    val books: ArrayList<Book> = arrayListOf(),

    @TableField(exist = false)
    val roles: ArrayList<Role> = arrayListOf(),

    @TableField(exist = false)
    val permissions: ArrayList<Permission> = arrayListOf()
)