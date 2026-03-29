package com.jklprojects.SpringAILearn;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OpenAITest {

  @Autowired
  private OpenAiChatModel chatModel;

  private ChatClient chatClient;

  @Test
  void testAskWhyIsSkyBlue() {
    String question = "Describe Canada's flag";

    chatClient = ChatClient.builder(chatModel).defaultAdvisors(new SimpleLoggerAdvisor()).build();

    var chatResponse = chatClient.prompt().user(question).call().content();

    assertNotNull(chatResponse, "response cannot be null");

    System.out.println("Response: " + chatResponse);
  }
}
