package com.springboot.practice.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {

    @GetMapping("/")
    fun index(): String {
        return "index"
    }

    @GetMapping("/posts/save")
    fun postsSave(): String {
        return "posts-save"
    }
}