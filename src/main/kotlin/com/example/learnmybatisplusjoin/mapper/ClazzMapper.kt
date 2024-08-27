package com.example.learnmybatisplusjoin.mapper

import com.example.learnmybatisplusjoin.entity.Clazz
import com.github.yulichang.base.MPJBaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface ClazzMapper : MPJBaseMapper<Clazz> {
}