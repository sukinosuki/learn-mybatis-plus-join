package com.example.learnmybatisplusjoin.mapper

import com.example.learnmybatisplusjoin.entity.Role
import com.github.yulichang.base.MPJBaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface RoleMapper : MPJBaseMapper<Role> {
}