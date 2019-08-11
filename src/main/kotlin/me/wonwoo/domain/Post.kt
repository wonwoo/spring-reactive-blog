package me.wonwoo.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDateTime

@Document
data class Post(

    @Id
    val id: ObjectId = ObjectId.get(),

    val title: String,

    val content: String,

    val regDate: LocalDateTime = LocalDateTime.now(),

    val author: String
)