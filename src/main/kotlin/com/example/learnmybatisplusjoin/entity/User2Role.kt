package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.TableName

@TableName("user_2_role")
data class User2Role(
    val userId: Long = 0,
    val roleId: Long = 0
)