package com.springboot.practice.service

import com.springboot.practice.domain.posts.PostsRepository
import com.springboot.practice.web.dto.PostsSaveRequestDto
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@RequiredArgsConstructor
@Service
class PostsService(
    val postsRepository: PostsRepository
) {
    @Transactional
    fun save(requestDto: PostsSaveRequestDto): Long? {
        return postsRepository.save(requestDto.toEntity()).id
    }
}