package langchain4j

import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.anthropic.AnthropicChatModel
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

fun main() {
  val model: ChatModel =
      AnthropicChatModel.builder()
          .apiKey(System.getenv("ANTHROPIC_API_KEY"))
          .modelName("claude-3-5-haiku-20241022")
          .build()

  // Send a user message and get the response
  val response = model.generate("Why is the sky blue?")

  log.info { response }
}
