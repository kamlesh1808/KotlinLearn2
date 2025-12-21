package kotlinlearn.haiku;

import java.util.Arrays;
import java.util.List;

public class Haiku {

  public static void main(String[] args) {

    List<String> haikus =
        Arrays.asList(
            "Winter moonlight glows / Silent snow upon the pines / Stillness fills the night",
            "Morning dew sparkles / Tiny webs between the grass / Sunlight wakes the earth",
            "Autumn leaves drifting / Whispering across the stream / Time dissolves in gold",
            "Cherry blossoms fall / Softly painting springtime air / Fragile dreams take flight",
            "Ocean waves crashing / Endless rhythm on the shore / Secrets of the deep");

    var h1 = "Winter moonlight glows Silent snow upon the pines Stillness fills the nigh";

    // 5, 7,5

    Haiku haiku = new Haiku();
    haiku.isHaiku(h1);
  }

  public boolean isHaiku(String str) {

    int[] haikuStruct = new int[] {5, 7, 5};

    var syllableCounter = new SyllableCounter();
    String[] words = str.split(" ");

    int syCounter = 0;
    int structCounter = 0;

    for (var w : words) {
      var sy = syllableCounter.countSyllables(w);
      System.out.println(w + " > " + sy);
      syCounter = syCounter + sy;

      if (haikuStruct[structCounter] == syCounter) {
        structCounter++;
        syCounter = 0;
      }
    }

    var isHaiku = structCounter == 3;
    System.out.println("isHaiku > " + isHaiku);

    return isHaiku;
  }
}
