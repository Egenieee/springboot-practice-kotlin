package com.springboot.practice.web.dto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class HelloReponseDtoTest {

    @Test
    fun 롬복_기능_테스트() {
        //given
        val name = "test"
        val amount = 1000;

        //when
        val dto = HelloResponseDto(name, amount)

        //then
        dto.name shouldBe name
        dto.amount shouldBe amount
    }
}