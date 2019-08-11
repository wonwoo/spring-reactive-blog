package me.wonwoo.web

import me.wonwoo.domain.PostRepository
import me.wonwoo.utils.MarkDownConverter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.reactive.result.view.Rendering

@Controller
class IndexController(private val postRepository: PostRepository,
                      private val markDownConverter: MarkDownConverter) {

  @GetMapping("/")
  fun home(): Rendering {
    return Rendering
        .view("index")
        .modelAttribute("posts", this.postRepository.findAll()
            .map { it.toDto(markDownConverter) })
        .build()
  }
}