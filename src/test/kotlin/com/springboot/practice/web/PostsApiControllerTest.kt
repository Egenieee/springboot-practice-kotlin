package com.springboot.practice.web

import com.springboot.practice.domain.posts.Posts
import com.springboot.practice.domain.posts.PostsRepository
import com.springboot.practice.web.dto.PostsSaveRequestDto
import com.springboot.practice.web.dto.PostsUpdateRequestDto
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PostsApiControllerTest(
    @LocalServerPort
    var port: Int,

    @Autowired
    var restTemplate: TestRestTemplate,

    @Autowired
    var postsRepository: PostsRepository
) {
    @AfterEach
    fun tearDown() {
        postsRepository.deleteAll()
    }

    @Test
    fun Posts_등록된다() {
        //given
        val title = "title"
        val content = "content"
        val author = "author"

        val requestDto = PostsSaveRequestDto(title, content, author)

        val url = "http://localhost:${port}/api/v1/posts"

        //when
        val responseEntity = restTemplate.postForEntity(url, requestDto, Long::class.java)

        //then
        responseEntity.statusCode shouldBe HttpStatus.OK
        responseEntity.body?.shouldBeGreaterThan(0L)

        val all: List<Posts> = postsRepository.findAll()
        all.get(0).title shouldBe title
        all.get(0).content shouldBe content
        all.get(0).author shouldBe author
    }

    @Test
    fun Posts_수정된다() {
        //given
        val savedPosts = postsRepository.save(
            Posts(
                id = 0L,
                title = "title",
                content = "content",
                author = "author"
            )
        )

        val updateId = savedPosts.id
        val expectedTitle = "title2"
        val expectedContent = "content2"

        val requestDto = PostsUpdateRequestDto(
            title = expectedTitle,
            content = expectedContent
        )

        val url = "http://localhost:${port}/api/v1/posts/${updateId}"

        val requestEntity: HttpEntity<PostsUpdateRequestDto> = HttpEntity(requestDto)

        //when
        val responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long::class.java)

        println(responseEntity)

        //then
        responseEntity.statusCode shouldBe HttpStatus.OK
        responseEntity.body?.shouldBeGreaterThan(0L)

        val all: List<Posts> = postsRepository.findAll()
        all.get(0).title shouldBe expectedTitle
        all.get(0).content shouldBe expectedContent
    }
}