package io.hsar.greeting

import org.slf4j.LoggerFactory
import java.io.InputStream

class LogGreeter: Greeter {

    companion object {
        private val logger = LoggerFactory.getLogger(LogGreeter::class.java)
    }

    override fun sendGreeting(greeting: String) {
        logger.info(greeting)
    }
}