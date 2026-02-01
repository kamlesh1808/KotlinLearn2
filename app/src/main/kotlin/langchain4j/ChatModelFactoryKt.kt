package langchain4j

import dev.langchain4j.model.anthropic.AnthropicChatModel
import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.openai.OpenAiChatModel
import dev.langchain4j.model.openai.OpenAiChatModelName.GPT_5_NANO

private val cache = mutableMapOf<ChatProvider, ChatModel>()

fun getChatModel(provider: ChatProvider): ChatModel =
    cache.getOrPut(provider) { createChatModel(provider) }

private fun createChatModel(provider: ChatProvider): ChatModel =
    when (provider) {
        ChatProvider.OPENAI -> OpenAiChatModel.builder()
            .apiKey(System.getenv("OPENAI_API_KEY"))
            .modelName(GPT_5_NANO)
            .build()
        ChatProvider.ANTHROPIC -> AnthropicChatModel.builder()
            .apiKey(System.getenv("ANTHROPIC_API_KEY"))
            .modelName("claude-haiku-4-5-20251001")
            .build()
    }
