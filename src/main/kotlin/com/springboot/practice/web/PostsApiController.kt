package com.springboot.practice.web

import com.springboot.practice.service.PostsService
import com.springboot.practice.web.dto.PostsResponseDto
import com.springboot.practice.web.dto.PostsSaveRequestDto
import com.springboot.practice.web.dto.PostsUpdateRequestDto
import lombok.RequiredArgsConstructor
import org.springframework.web.bind.annotation.*

@RequiredArgsConstructor
@RestController
class PostsApiController(
    val postsService: PostsService
) {
    @PostMapping("/api/v1/posts") // 등록
    fun save(@RequestBody requestDto: PostsSaveRequestDto): Long {
        return postsService.save(requestDto)
    }

    @PutMapping("/api/v1/posts/{id}") // 수정
    fun update(@PathVariable id: Long, @RequestBody requestDto: PostsUpdateRequestDto): Long {
        return postsService.update(id, requestDto)
    }

    @GetMapping("/api/v1/posts/{id}") // 조회
    fun findById(@PathVariable id: Long): PostsResponseDto {
        return postsService.findById(id)
    }

    @DeleteMapping("/api/v1/posts/{id}") // 삭제
    fun delete(@PathVariable id: Long): Long {
        postsService.delete(id)
        return id
    }
}