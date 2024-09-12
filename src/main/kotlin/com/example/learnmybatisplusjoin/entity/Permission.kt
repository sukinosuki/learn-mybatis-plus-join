package com.example.learnmybatisplusjoin.entity

import com.fasterxml.jackson.annotation.JsonInclude

data class Permission(
    val id: Long = 0,

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    val name: String = "",
)
