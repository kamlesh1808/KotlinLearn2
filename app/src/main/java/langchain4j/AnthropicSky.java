package langchain4j;

import dev.langchain4j.model.anthropic.AnthropicChatModel;
import dev.langchain4j.model.chat.ChatModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnthropicSky {

  public static void main(String[] args) {
    ChatModel model =
        AnthropicChatModel.builder()
            .apiKey(System.getenv("ANTHROPIC_API_KEY"))
            .modelName("claude-haiku-4-5-20251001")
            .build();

    // Send a user message and get the response
    String response = model.chat("Why is the sky blue?");

    log.info(response);
  }
}
