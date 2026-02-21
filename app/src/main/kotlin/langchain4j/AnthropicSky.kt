package langchain4j

import dev.langchain4j.model.chat.ChatModel
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

fun main() {
    val model: ChatModel = getChatModel(ChatProvider.ANTHROPIC)

    // Send a user message and get the response
    val response = model.chat("Why is the sky blue?")

    log.info { response }
}
