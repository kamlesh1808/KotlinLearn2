package langchain4j

enum class ChatProvider(val aliases: List<String>) {
  OPENAI(listOf("openai", "gpt")),
  ANTHROPIC(listOf("anthropic", "claude"));

  companion object {
    fun fromString(provider: String): ChatProvider {
      require(provider.isNotBlank()) { "Provider cannot be null or blank" }

      val lowercase = provider.lowercase()
      return ChatProvider.values().find { p ->
        p.aliases.any { it == lowercase }
      } ?: throw IllegalArgumentException("Unknown provider: $provider")
    }
  }
}
