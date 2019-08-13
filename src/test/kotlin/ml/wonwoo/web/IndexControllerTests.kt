package ml.wonwoo.web

import ml.wonwoo.domain.Post
import ml.wonwoo.domain.PostRepository
import ml.wonwoo.utils.MarkDownConverter
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.boot.test.mock.mockito.SpyBean
import org.springframework.test.context.TestConstructor
import org.springframework.test.context.TestConstructor.AutowireMode.ALL
import org.springframework.test.web.reactive.server.WebTestClient
import org.springframework.test.web.reactive.server.expectBody
import reactor.core.publisher.Flux


@WebFluxTest(IndexController::class)
@TestConstructor(autowireMode = ALL)
internal class IndexControllerTests(private val webTestClient: WebTestClient) {

    @MockBean
    private lateinit var postRepository: PostRepository

    @SpyBean
    private lateinit var markDownConverter: MarkDownConverter

    @Test
    fun `index page test`() {

        given(postRepository.findAll()).willReturn(Flux.just(Post(title = "test web", content = "foo test", author = "wonwoo")))

        webTestClient.get().uri("/")
            .exchange()
            .expectStatus().isOk
            .expectBody<String>()
            .consumeWith {

                val body = it.responseBody

                assertThat(body).contains("test web")
                assertThat(body).contains("foo test")
                assertThat(body).contains("wonwoo")

            }

    }
}