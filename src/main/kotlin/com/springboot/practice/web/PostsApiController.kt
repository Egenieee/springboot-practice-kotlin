package com.springboot.practice.web

import com.springboot.practice.service.PostsService
import com.springboot.practice.web.dto.PostsSaveRequestDto
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RequiredArgsConstructor
@RestController
class PostsApiController(
    val postsService: PostsService
) {
    @PostMapping("/api/v1/posts")
    fun save(@RequestBody requestDto: PostsSaveRequestDto): Long? {
        return postsService.save(requestDto)
    }
}