package ml.wonwoo.client

import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import reactor.core.publisher.Mono

@Component
class BlogClient(builder: WebClient.Builder, blogProperties: BlogProperties) {

    private val webClient = builder.baseUrl(blogProperties.url).build()

    fun posts(): Mono<Content> = webClient
        .get()
        .uri("/api/posts")
        .retrieve()
        .bodyToMono()

}