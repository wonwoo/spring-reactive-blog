package me.wonwoo.web

import me.wonwoo.domain.Post
import me.wonwoo.domain.User
import me.wonwoo.utils.MarkDownConverter
import me.wonwoo.utils.Utils

data class PostDto(
    val id: String,
    val title: String,
    val content: String,
    val addedAt: String,
    val author: User)

fun Post.toDto(markdownConverter: MarkDownConverter) = PostDto(
    id,
    title,
    markdownConverter(content),
    Utils.formatToEnglish(localDateTime),
    author
)
