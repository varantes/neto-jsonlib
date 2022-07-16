@file:Suppress("unused")

package neto.jsonlib.json

import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

private val mapper = jacksonObjectMapper().registerModule(JavaTimeModule())
    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)

private val prettyMapper = mapper.writerWithDefaultPrettyPrinter()

fun Any.json(): String? = prettyMapper.writeValueAsString(this)