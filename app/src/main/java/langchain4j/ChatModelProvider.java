package langchain4j;

public enum ChatModelProvider {
  OPENAI("openai", "gpt"),
  ANTHROPIC("anthropic", "claude");

  private final String[] aliases;

  ChatModelProvider(String... aliases) {
    this.aliases = aliases;
  }

  public String[] getAliases() {
    return aliases;
  }

  public static ChatModelProvider fromString(String provider) {
    if (provider == null || provider.isBlank()) {
      throw new IllegalArgumentException("Provider cannot be null or blank");
    }

    String lowercase = provider.toLowerCase();
    for (ChatModelProvider p : ChatModelProvider.values()) {
      for (String alias : p.aliases) {
        if (alias.equals(lowercase)) {
          return p;
        }
      }
    }
    throw new IllegalArgumentException("Unknown provider: " + provider);
  }
}
