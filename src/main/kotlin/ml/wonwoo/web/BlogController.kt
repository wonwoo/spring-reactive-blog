package ml.wonwoo.web

import ml.wonwoo.client.Blog
import ml.wonwoo.client.BlogClient
import ml.wonwoo.utils.formatToEnglish
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.reactive.result.view.Rendering

@Controller
class BlogController(private val blogClient: BlogClient) {

    @GetMapping("/blog")
    fun blog(): Rendering {
        return Rendering
            .view("blog")
            .modelAttribute("posts", this.blogClient.posts()
                .map { it.content.map { blog -> blog.toDto() } }
            )
            .build()
    }
}

data class BlogDto(

    val id: String,

    val title: String,

    val content: String,

    val addedAt: String
)


fun Blog.toDto() = BlogDto(id, postTitle, postContent, postDate.formatToEnglish())