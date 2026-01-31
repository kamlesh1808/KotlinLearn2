package langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.anthropic.AnthropicChatModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnthropicSky {

  public static void main(String[] args) {
    ChatModel model =
        AnthropicChatModel.builder()
            .apiKey(System.getenv("ANTHROPIC_API_KEY"))
            .modelName("claude-3-5-haiku-20241022")
            .build();

    // Send a user message and get the response
    String response = model.generate("Why is the sky blue?");

    log.info(response);
  }
}
