package ml.wonwoo.client

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime

data class Blog(

    @JsonProperty("ID")
    val id: String,

    @JsonProperty("post_title")
    val postTitle: String,

    @JsonProperty("post_content")
    val postContent: String,

    @JsonProperty("post_date")
    val postDate : LocalDateTime
)

data class Content(

    @JsonProperty("content")
    val content: List<Blog>

)