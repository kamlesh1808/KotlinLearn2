package langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.model.anthropic.AnthropicChatModel;
import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_5_NANO;
import java.util.EnumMap;
import java.util.Map;

public class ChatModelFactory {

  private static final Map<ChatModelProvider, ChatModel> cache = new EnumMap<>(ChatModelProvider.class);

  public static ChatModel getChatModel(ChatModelProvider provider) {
    return cache.computeIfAbsent(provider, ChatModelFactory::createChatModel);
  }

  public static ChatModel getChatModel(String provider) {
    return getChatModel(ChatModelProvider.fromString(provider));
  }

  private static ChatModel createChatModel(ChatModelProvider provider) {
    return switch (provider) {
      case OPENAI -> OpenAiChatModel.builder()
          .apiKey(System.getenv("OPENAI_API_KEY"))
          .modelName(GPT_5_NANO)
          .build();
      case ANTHROPIC -> AnthropicChatModel.builder()
          .apiKey(System.getenv("ANTHROPIC_API_KEY"))
          .modelName("claude-haiku-4-5-20251001")
          .build();
    };
  }
}
