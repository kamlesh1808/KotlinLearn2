package langchain4j

import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.openai.OpenAiChatModel
import dev.langchain4j.model.openai.OpenAiChatModelName.GPT_5_NANO
import mu.KotlinLogging

private val log = KotlinLogging.logger {}

fun main() {
  val model: ChatModel =
      OpenAiChatModel.builder()
          .apiKey(System.getenv("OPENAI_API_KEY"))
          .modelName(GPT_5_NANO)
          .build()

  // Send a user message and get the response
  val response = model.generate("Why is the sky blue?")

  log.info { response }
}
