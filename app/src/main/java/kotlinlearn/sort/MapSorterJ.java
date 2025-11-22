package kotlinlearn.sort;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorterJ {

  public static Map<String, Integer> sortByValueDesc(Map<String, Integer> map) {
    return map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(
            Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (e1, e2) -> e1, // merge function (not needed here)
                LinkedHashMap::new // preserve order
                ));
  }

  public static void main(String[] args) {
    var sample = new HashMap<String, Integer>();
    sample.put("Alice", 3);
    sample.put("Bob", 5);
    sample.put("Charlie", 1);

    var sorted = sortByValueDesc(sample);
    System.out.println(sorted);
    // Output: {Bob=5, Alice=3, Charlie=1}
  }
}
