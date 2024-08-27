package com.example.learnmybatisplusjoin

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@MapperScan("com.example.learnmybatisplusjoin.mapper")
class LearnMybatisPlusJoinApplication

fun main(args: Array<String>) {
    runApplication<LearnMybatisPlusJoinApplication>(*args)
}
