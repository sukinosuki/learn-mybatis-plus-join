package com.example.learnmybatisplusjoin.mapper

import com.example.learnmybatisplusjoin.entity.User
import com.github.yulichang.base.MPJBaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper : MPJBaseMapper<User> {

}