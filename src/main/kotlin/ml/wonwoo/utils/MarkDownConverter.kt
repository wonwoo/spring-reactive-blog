package ml.wonwoo.utils

import org.commonmark.ext.autolink.AutolinkExtension
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils

@Service
class MarkDownConverter : (String?) -> String {

    private val parser = Parser.builder().extensions(listOf(AutolinkExtension.create())).build()

    private val renderer = HtmlRenderer.builder().build()

    override fun invoke(input: String?): String {

        if (!StringUtils.hasText(input)) {

            return ""

        }

        return this.renderer.render(this.parser.parse(input))

    }

}