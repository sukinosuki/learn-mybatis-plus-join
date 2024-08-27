package com.example.learnmybatisplusjoin.entity

import com.baomidou.mybatisplus.annotation.TableName

@TableName("role_2_permission")
data class Role2Permission(
    val roleId: Long = 0,
    val permissionId: Long = 0
)