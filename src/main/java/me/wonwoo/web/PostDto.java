package me.wonwoo.web;

import me.wonwoo.domain.Post;
import me.wonwoo.domain.User;
import me.wonwoo.utils.MarkDownConverter;
import me.wonwoo.utils.Utils;

public class PostDto {

  private final String id;

  private final String title;

  private final String content;

  private final String addedAt;

  private final User author ;

  public PostDto(Post post, MarkDownConverter markDownConverter) {
    this.id = post.getId();
    this.title = post.getTitle();
    this.content = markDownConverter.invoke(post.getContent());
    this.addedAt = Utils.formatToEnglish(post.getLocalDateTime());
    this.author = post.getAuthor();
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getAddedAt() {
    return addedAt;
  }

  public User getAuthor() {
    return author;
  }
}
