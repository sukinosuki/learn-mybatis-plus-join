package com.example.learnmybatisplusjoin.common

class JsonValueNegativeFilter {

    override fun equals(other: Any?): Boolean {

        if (other == null) return true

        return when (other) {
            is Long -> other < 0
            is Int -> other < 0
            else -> false
        }
    }
}