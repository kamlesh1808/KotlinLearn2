package kotlinlearn.haiku;

public class SyllableCounter {

  public static final String VOWELS = "aeiouy";

  public static int countSyllables(String word) {
    if (word == null || word.isEmpty()) {
      return 0;
    }

    word = word.toLowerCase().trim();

    // Remove non-alphabetic characters
    word = word.replaceAll("[^a-z]", "");

    // If empty after cleaning
    if (word.isEmpty()) {
      return 0;
    }

    boolean prevVowel = false;
    int syllableCount = 0;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);

      if (VOWELS.indexOf(c) >= 0) {
        // New vowel group → new syllable
        if (!prevVowel) {
          syllableCount++;
          prevVowel = true;
        }
      } else {
        prevVowel = false;
      }
    }

    // Adjust for silent "e" at the end
//    if (word.endsWith("e") && syllableCount > 1) {
//      syllableCount--;
//    }

    // Ensure at least 1 syllable
    return Math.max(syllableCount, 1);
  }

  public static void main(String[] args) {
    String[] words = {"cat", "happy", "beautiful", "extraordinary", "cake"};
    for (String w : words) {
      System.out.println(w + " → " + countSyllables(w));
    }
  }
}
