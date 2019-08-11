package me.wonwoo.domain

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import reactor.core.publisher.Flux

interface PostRepository : ReactiveMongoRepository<Post, ObjectId> {

    fun findByTitle(title: String) : Flux<Post>

}