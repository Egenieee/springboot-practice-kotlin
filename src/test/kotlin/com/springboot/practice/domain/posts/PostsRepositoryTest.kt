package com.springboot.practice.domain.posts

import io.kotest.assertions.print.print
import io.kotest.matchers.date.shouldBeAfter
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime

//@WebMvcTest
@SpringBootTest
class PostsRepositoryTest(
    @Autowired
    var postsRepository: PostsRepository
) {
    @AfterEach
    fun cleanup() {
        postsRepository.deleteAll()
    }

    @Test
    fun 게시글저장_불러오기() {
        //given
        val title = "테스트 게시글"
        val content = "테스트 본문"

        val post = Posts(
            id = 1L,
            title = title,
            content = content,
            author = "ab23202304@gmail.com"
        )

        postsRepository.save(post)

        //when
        val postsList: List<Posts> = postsRepository.findAll()

        //then
        val posts: Posts = postsList.get(0)
        posts.title shouldBe title
        post.content shouldBe content
        post.title.print()
    }

    @Test
    fun BaseTimeEntity_등록() {
        //given
        val now = LocalDateTime.of(2022, 8, 27, 0, 0, 0)
        postsRepository.save(
            Posts(
                id = 1L,
                title = "title",
                content = "content",
                author = "author"
            )
        )

        //when
        val postsList: List<Posts> = postsRepository.findAll()

        //then
        val posts = postsList.get(0)

        println(">>>>>>>>>>>>>>> createDate=${posts.createdDate}, modifiedDate=${posts.modifiedDate}")

        posts.createdDate?.shouldBeAfter(now)
        posts.modifiedDate?.shouldBeAfter(now)
    }
}