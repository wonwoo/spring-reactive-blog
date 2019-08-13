package ml.wonwoo.web

import ml.wonwoo.domain.Post
import ml.wonwoo.domain.PostRepository
import ml.wonwoo.utils.MarkDownConverter
import org.assertj.core.api.Assertions
import org.bson.types.ObjectId
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import reactor.core.publisher.Mono


@WebFluxTest(PostController::class)
internal class PostControllerTests(private val webTestClient: WebTestClient) {

    @MockBean
    private lateinit var postRepository: PostRepository

    @SpyBean
    private lateinit var markDownConverter: MarkDownConverter

    @Test
    internal fun `post page test`() {

        given(postRepository.findById(any<ObjectId>())).willReturn(Mono.just(Post(title = "test web", content = "foo test", author = "wonwoo")))

        webTestClient.get().uri("/{id}", ObjectId.get())
            .exchange()
            .expectStatus().isOk
            .expectBody<String>()
            .consumeWith {

                val body = it.responseBody

                Assertions.assertThat(body).contains("test web")
                Assertions.assertThat(body).contains("foo test")
                Assertions.assertThat(body).contains("wonwoo")

            }

    }
}