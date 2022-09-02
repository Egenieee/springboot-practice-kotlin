package com.springboot.practice.web

import com.springboot.practice.service.PostsService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController(
    val postsService: PostsService
) {

    @GetMapping("/")
    fun index(model: Model): String {
        model.addAttribute(("posts"), postsService.findAllDesc())
        return "index"
    }

    @GetMapping("/posts/save")
    fun postsSave(): String {
        return "posts-save"
    }
}

//Model에는 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.