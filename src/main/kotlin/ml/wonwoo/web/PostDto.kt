package ml.wonwoo.web

import ml.wonwoo.domain.Post
import ml.wonwoo.utils.MarkDownConverter
import ml.wonwoo.utils.formatToEnglish
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
    regDate.formatToEnglish(),
    author
)
