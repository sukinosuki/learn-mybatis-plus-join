package com.example.learnmybatisplusjoin

import com.example.learnmybatisplusjoin.modules.user.UserController
import jakarta.annotation.Resource
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MockMvcBuilder
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import org.springframework.web.context.WebApplicationContext

//@WebMvcTest(UserController::class)
//@SpringBootTest(classes = [SpringBootApplication::class], webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@SpringBootTest()
class UserControllerTest2 {

    @Autowired
    lateinit var webApplicationContext: WebApplicationContext
//
//     No qualifying bean of type 'org.springframework.test.web.servlet.MockMvc' available
//     https://stackoverflow.com/questions/51299015/springboottest-no-qualifying-bean-of-type-org-springframework-test-web-servle
    val mockMvc by lazy {
        MockMvcBuilders.webAppContextSetup(webApplicationContext).build()
    }

    @Test
    fun testControllerGetUserBookById() {
        val userId = 1
        val requestBuilder = MockMvcRequestBuilders.get("/api/v1/user/{id}/book", userId)
        val result = mockMvc
            .perform(requestBuilder)
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andDo(MockMvcResultHandlers.print())
            .andReturn()

        println("result: $result")
    }
}