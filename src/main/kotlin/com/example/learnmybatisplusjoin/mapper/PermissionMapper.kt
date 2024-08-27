package com.example.learnmybatisplusjoin.mapper

import com.example.learnmybatisplusjoin.entity.Permission
import com.github.yulichang.base.MPJBaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface PermissionMapper : MPJBaseMapper<Permission> {
}