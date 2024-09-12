package com.example.learnmybatisplusjoin.modules.book.form

data class BookFormAdd(
    val name: String,
    val author: String,
    val uid: Long,
    val categoryId: Long
)