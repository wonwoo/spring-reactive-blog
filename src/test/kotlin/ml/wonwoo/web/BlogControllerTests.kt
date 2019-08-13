package ml.wonwoo.web

import ml.wonwoo.client.Blog
import ml.wonwoo.client.BlogClient
import ml.wonwoo.client.Content
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import reactor.core.publisher.Mono
import java.time.LocalDateTime

typealias Date = LocalDateTime

@WebFluxTest(BlogController::class)
internal class BlogControllerTests(private val webTestClient: WebTestClient) {

    @MockBean
    private lateinit var blogClient: BlogClient

    @Test
    internal fun `blog page test`() {


        val content = Content(listOf(Blog(id = "id", postTitle = "test web", postContent = "foo test", postDate = Date.now())))

        given(blogClient.posts()).willReturn(Mono.just(content))

        webTestClient.get().uri("/blog")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>()
            .consumeWith {

                val body = it.responseBody

                Assertions.assertThat(body).contains("test web")
                Assertions.assertThat(body).contains("foo test")

            }

    }
}