package com.example.learnmybatisplusjoin.modules.user.form

data class FormGet(
    var page: Long? = 1,

    var size: Long? = 10,

    var order: String? = "desc"
)