package langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import lombok.extern.slf4j.Slf4j;

import static dev.langchain4j.model.openai.OpenAiChatModelName.GPT_5_NANO;

@Slf4j
public class BlueSky {

  static void main() {
    ChatModel model =
        OpenAiChatModel.builder()
            .apiKey(System.getenv("OPENAI_API_KEY"))
            .modelName(GPT_5_NANO)
            .build();

    // Send a user message and get the response
    String response = model.chat("Why is the sky blue?");

    log.info(response);
  }
}
