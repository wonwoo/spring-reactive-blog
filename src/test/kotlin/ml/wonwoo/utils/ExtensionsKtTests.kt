package ml.wonwoo.utils

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.time.LocalDateTime

internal class ExtensionsKtTests{

    @Test
    fun `format to english test`() {
        val date = LocalDateTime.of(2019, 8, 12, 12,22)

        val formatToEnglish = date.formatToEnglish()

        assertThat(formatToEnglish).isEqualTo("August 12th 2019")

    }
}