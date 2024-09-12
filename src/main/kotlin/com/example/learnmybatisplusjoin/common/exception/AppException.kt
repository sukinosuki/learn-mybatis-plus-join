package com.example.learnmybatisplusjoin.common.exception

import java.lang.RuntimeException

data class RecordNotFoundException(
    val msg: String ="Record not found"
) : RuntimeException()