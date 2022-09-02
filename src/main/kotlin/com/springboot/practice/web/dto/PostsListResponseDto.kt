package com.springboot.practice.web.dto

import com.springboot.practice.domain.posts.Posts
import java.time.LocalDateTime

class PostsListResponseDto(
    var id: Long,
    var title: String,
    var author: String,
    var modifiedDate: LocalDateTime?
) {
    constructor(entity: Posts) : this(
        id = entity.id,
        title = entity.title,
        author = entity.author,
        modifiedDate = entity.modifiedDate
    )
}