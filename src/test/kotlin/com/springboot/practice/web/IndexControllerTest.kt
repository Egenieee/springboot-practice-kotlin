package com.springboot.practice.web

import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IndexControllerTest(
    @Autowired
    val restTemplate: TestRestTemplate

) {

    @Test
    fun 메인_페이지_로딩() {
        //when
        val body = restTemplate.getForEntity("/", String::class.java)

        //then
        body.body?.shouldContain("스프링 부트로 시작하는 웹 서비스")
    }
}