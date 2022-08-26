package com.springboot.practice.web.dto

import com.springboot.practice.domain.posts.Posts

class PostsResponseDto(
    var id: Long,
    var title: String,
    var content: String,
    var author: String
) {
    constructor(entity: Posts) : this(
        id = entity.id,
        title = entity.title,
        content = entity.content,
        author = entity.author
    )
}