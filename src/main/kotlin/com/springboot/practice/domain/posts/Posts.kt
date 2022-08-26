package com.springboot.practice.domain.posts

import javax.persistence.*

@Entity
class Posts(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk 생성규칙
    val id: Long? = null,

    @Column(length = 500, nullable = false)
    var title: String,

    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String,

    var author: String

) {

}