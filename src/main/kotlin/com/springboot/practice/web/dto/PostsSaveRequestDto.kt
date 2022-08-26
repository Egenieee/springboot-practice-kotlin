package com.springboot.practice.web.dto

import com.springboot.practice.domain.posts.Posts

class PostsSaveRequestDto(
    var title: String,
    var content: String,
    var author: String
) {

    fun toEntity(): Posts {
        return Posts(
            null,
            this.title,
            this.content,
            this.author
        )
    }
}