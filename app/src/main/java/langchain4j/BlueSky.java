package langchain4j;

import dev.langchain4j.model.chat.ChatModel;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlueSky {

  public static void main(String[] args) {
    ChatModel model = ChatModelFactory.getChatModel(ChatModelProvider.OPENAI);

    // Send a user message and get the response
    String response = model.chat("Why is the sky blue?");

    log.info(response);
  }
}
