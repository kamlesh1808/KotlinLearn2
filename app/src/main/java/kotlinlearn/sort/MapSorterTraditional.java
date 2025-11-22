package kotlinlearn.sort;

import java.util.*;

public class MapSorterTraditional {

  public static Map<String, Integer> sortByValueDesc(Map<String, Integer> map) {
    // Convert map entries into a list
    var entryList = new ArrayList<>(map.entrySet());

    // Sort the list by value in descending order using a lambda
    entryList.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));


    // Preserve order in a LinkedHashMap
    var sortedMap = new LinkedHashMap<String, Integer>();
    for (var entry : entryList) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
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
