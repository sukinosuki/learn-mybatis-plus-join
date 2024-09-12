package com.example.learnmybatisplusjoin

import com.example.learnmybatisplusjoin.modules.user.UserController
import com.example.learnmybatisplusjoin.modules.user.UserDao
import com.example.learnmybatisplusjoin.modules.user.UserService
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
//import kotlin.test.Test
import kotlin.test.assertSame

@SpringBootTest
//@WebMvcTest(UserController::class)
class UserServiceTest {

    @Autowired
    lateinit var userService: UserService

//    @Autowired
//    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var userDao: UserDao

    @Test
    fun testServiceGetUserBookById() {
        val id: Long = 1
        val user = userService.getUserBookById(id)

//        assertSame(1, user.id)
    }

//    @Test
//    fun testControllerGetUserBookById() {
//        val userId = 1
//        val requestBuilder = MockMvcRequestBuilders.get("/api/v1/user/{id}/book", userId)
//        mockMvc
//            .perform(requestBuilder)
//            .andExpect(MockMvcResultMatchers.status().isOk)
//            .andDo(MockMvcResultHandlers.print())
//    }
}