package com.springboot.practice.web

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest
@AutoConfigureMockMvc
class HelloControllerTest (
    @Autowired
    private val mockMvc: MockMvc
    )
{

    @Test
    fun hello가_리턴된다() {
        mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.content().string("hello"))
    }

    @Test
    fun helloDto가_리턴된다() {
        val name = "hello";
        val amount = 1000;

        mockMvc.perform(MockMvcRequestBuilders.get("/hello/dto")
            .param("name", name)
            .param("amount", amount.toString()))
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(name))
            .andExpect(MockMvcResultMatchers.jsonPath("$.amount").value(amount))
    }
}