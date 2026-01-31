package langchain4j

import dev.langchain4j.model.anthropic.AnthropicChatModel
import dev.langchain4j.model.chat.ChatModel
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

fun main() {
    val model: ChatModel =
        AnthropicChatModel.builder()
            .apiKey(System.getenv("ANTHROPIC_API_KEY"))
            .modelName("claude-haiku-4-5-20251001")
            .build()

    // Send a user message and get the response
    val response = model.chat("Why is the sky blue?")

    log.info { response }
}
