package me.wonwoo.web

import me.wonwoo.domain.Post
import me.wonwoo.utils.MarkDownConverter
import me.wonwoo.utils.formatToEnglish
import org.bson.types.ObjectId

data class PostDto(

    val id: ObjectId,

    val title: String,

    val content: String,

    val addedAt: String,

    val author: String

)

fun Post.toDto(markdownConverter: MarkDownConverter) = PostDto(
    id,
    title,
    markdownConverter(content),
    formatToEnglish(regDate),
    author
)
