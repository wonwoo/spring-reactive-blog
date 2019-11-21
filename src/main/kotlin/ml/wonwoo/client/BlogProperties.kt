package ml.wonwoo.client

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties("blog")
@ConstructorBinding
class BlogProperties(

    val url: String

)