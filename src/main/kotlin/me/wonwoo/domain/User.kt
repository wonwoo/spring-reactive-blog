package me.wonwoo.domain

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(

    @Id
    val id: ObjectId = ObjectId.get(),

    val name: String
)