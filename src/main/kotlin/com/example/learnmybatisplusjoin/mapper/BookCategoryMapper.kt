package com.example.learnmybatisplusjoin.mapper

import com.example.learnmybatisplusjoin.entity.BookCategory
import com.github.yulichang.base.MPJBaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface BookCategoryMapper : MPJBaseMapper<BookCategory> {
}