package me.wonwoo.utils

import org.commonmark.ext.autolink.AutolinkExtension
import org.commonmark.parser.Parser
import org.commonmark.renderer.html.HtmlRenderer
import org.springframework.stereotype.Service
import org.springframework.util.StringUtils
import java.util.*

@Service
class MarkDownConverter : (String?) -> String  {

  private val parser = Parser.builder().extensions(Arrays.asList(AutolinkExtension.create())).build()
  private val renderer = HtmlRenderer.builder().build()

  override fun invoke(input: String?): String {

    if(!StringUtils.hasText(input)) {
      return "";
    }
    return renderer.render(parser.parse(input))
  }

}