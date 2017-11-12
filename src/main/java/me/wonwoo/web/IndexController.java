package me.wonwoo.web;

import me.wonwoo.domain.PostRepository;
import me.wonwoo.utils.MarkDownConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.result.view.Rendering;

@Controller
public class IndexController {

  private final PostRepository postRepository;
  private final MarkDownConverter markDownConverter;

  public IndexController(PostRepository postRepository, MarkDownConverter markDownConverter) {
    this.postRepository = postRepository;
    this.markDownConverter = markDownConverter;
  }

  @GetMapping("/")
  public Rendering home() {
    return Rendering
        .view("index")
        .modelAttribute("posts", this.postRepository.findAll()
            .map(post -> new PostDto(post, markDownConverter)))
        .build();
  }
}
