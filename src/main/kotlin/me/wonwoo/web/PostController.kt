package me.wonwoo.web

import me.wonwoo.domain.PostRepository
import me.wonwoo.utils.MarkDownConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.reactive.result.view.Rendering

@Controller
class PostController(private val postRepository: PostRepository, private val markDownConverter: MarkDownConverter) {

  @GetMapping("/{title}")
  fun home(@PathVariable title: String): Rendering {
    return Rendering
        .view("post")
        .modelAttribute("post", this.postRepository.findByTitle(title)
            .map { it.toDto(markDownConverter) })
        .build()
  }
}
