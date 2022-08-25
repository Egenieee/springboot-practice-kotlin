package com.springboot.practice.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    public fun hello() : String {
        return "hello"
    }
}