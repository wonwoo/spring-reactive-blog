package ml.wonwoo.client

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties("blog")
class BlogProperties(

    val url: String

)