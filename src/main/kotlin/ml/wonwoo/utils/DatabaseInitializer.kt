package ml.wonwoo.utils

import ml.wonwoo.domain.Post
import ml.wonwoo.domain.PostRepository
import ml.wonwoo.domain.User
import ml.wonwoo.domain.UserRepository
import org.springframework.beans.factory.SmartInitializingSingleton
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class DatabaseInitializer(private val postRepository: PostRepository,
                          private val userRepository: UserRepository) : SmartInitializingSingleton {

    override fun afterSingletonsInstantiated() {

        val user1 = User(name = "wonwoo")
        val user2 = User(name = "kevin")

        val post1 = Post(
            title = "Spring5 reactive",
            content = "With the release of [Spring Framework 5.0](https://spring.io/blog/2017/09/28/spring-framework-5-0-goes-ga) now just happening, you can imagine this is a giant step for Project Reactor :)\n",
            author = user1.name,
            regDate = LocalDateTime.of(2019, 7, 28, 12, 0)
        )
        val post2 = Post(
            title = "Spring5 reactive source",
            content = "\n```java\n" +
                "@SpringBootApplication\n" +
                "public class SpringReactiveBlogApplication {\n" +
                "\n" +
                "\tpublic static void main(String[] args) {\n" +
                "\t\tSpringApplication.run(SpringReactiveBlogApplication.class, args);\n" +
                "\t}\n" +
                "}\n```\n",
            author = user2.name,
            regDate = LocalDateTime.of(2019, 8, 20, 11, 10)
        )
        val post3 = Post(
            title = "Spring reactor",
            content = "### Flux \n A Reactive Streams Publisher with rx operators that emits `0` to `N` elements, and then completes (successfully or with an error). \n ### Mono  \n A Reactive Streams Publisher with basic rx operators that completes successfully by emitting an element, or with an error.\n",
            author = user1.name,
            regDate = LocalDateTime.of(2019, 8, 25, 7, 16)
        )

        userRepository.deleteAll()
            .thenMany(postRepository.deleteAll())
            .thenMany(this.userRepository.saveAll(listOf(user1, user2)))
            .thenMany(postRepository.saveAll(listOf(post1, post2, post3)))
            .thenMany(postRepository.findAll())
            .subscribe { println(it) }
    }

}