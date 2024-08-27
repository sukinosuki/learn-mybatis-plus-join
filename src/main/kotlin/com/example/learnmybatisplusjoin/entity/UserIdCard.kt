package com.example.learnmybatisplusjoin.entity

import jakarta.persistence.*
import org.hibernate.annotations.IdGeneratorType
import java.time.LocalDateTime


//@Entity
data class UserIdCard(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val uid: Long = 0,

    val cardNumber: String = "",

    val createdAt: LocalDateTime? = null,

    val updatedAt: LocalDateTime? = null,

    val deletedAt: LocalDateTime? = null,

//    @OneToOne(cascade = [CascadeType.ALL])
//    @JoinColumn(name = "uid", referencedColumnName = "id")
//    val user:User? = null
)