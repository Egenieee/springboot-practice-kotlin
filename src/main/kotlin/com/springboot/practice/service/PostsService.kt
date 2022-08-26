package com.springboot.practice.service

import com.springboot.practice.domain.posts.Posts
import com.springboot.practice.domain.posts.PostsRepository
import com.springboot.practice.web.dto.PostsSaveRequestDto
import com.springboot.practice.web.dto.PostsUpdateRequestDto
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

    @Transactional
    fun update(id: Long, requestDto: PostsUpdateRequestDto): Long {
        val posts: Posts = (postsRepository.findById(id)
            .orElseThrow() ?: IllegalArgumentException("해당 게시글이 없습니다. id=${id}")) as Posts

        posts.update(requestDto.title, requestDto.content)

        return id
    }
}