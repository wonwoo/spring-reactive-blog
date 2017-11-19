package me.wonwoo.web

import me.wonwoo.domain.Post
import me.wonwoo.domain.User
import me.wonwoo.utils.MarkDownConverter
import me.wonwoo.utils.Utils

data class PostDto(
    val title: String,
    val content: String,
    val addedAt: String,
    val author: User)

fun Post.toDto(markdownConverter: MarkDownConverter) = PostDto(
    title,
    markdownConverter(content),
    Utils.formatToEnglish(localDateTime),
    author
)
