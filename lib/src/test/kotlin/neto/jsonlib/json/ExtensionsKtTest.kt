package neto.jsonlib.json

import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert
import java.time.LocalDateTime

class ExtensionsKtTest {
    @Test
    fun `json of simple map`() {
        val json = mapOf(
            "nome" to "nome1",
            "idade" to 35,
            "dia" to LocalDateTime.of(
                2000,
                12,
                30,
                15,
                15,
                45
            )
        ).json()!!
        println(json)
        JSONAssert.assertEquals("""
            {
              "nome" : "nome1",
              "idade" : 35,
              "dia" : "2000-12-30T15:15:45"
            }
        """.trimIndent(), json, true)
    }
}