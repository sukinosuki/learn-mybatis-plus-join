package com.example.learnmybatisplusjoin.common

data class R<T>(
    val code: Long,
    val msg: String,
    val data: T? = null
) {

    companion object {
        fun <T> ok(data: T? = null): R<T?> {
            return R(code = 0, msg = "ok", data = data)
        }

        fun error(code: Long = -1, msg: String): R<Any?> {
            return R(code = code, msg = msg)
        }
    }
}
