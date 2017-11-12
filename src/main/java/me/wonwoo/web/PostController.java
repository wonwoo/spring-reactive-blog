package me.wonwoo.web;

import me.wonwoo.domain.PostRepository;
import me.wonwoo.utils.MarkDownConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
public class PostController {

  private final PostRepository postRepository;
  private final MarkDownConverter markDownConverter;

  public PostController(PostRepository postRepository, MarkDownConverter markDownConverter) {
    this.postRepository = postRepository;
    this.markDownConverter = markDownConverter;
  }

  @GetMapping("/{title}")
  public Rendering home(@PathVariable String title) {
    return Rendering
        .view("post")
        .modelAttribute("post", this.postRepository.findByTitle(title)
            .map(post -> new PostDto(post, markDownConverter)))
        .build();
  }
}
