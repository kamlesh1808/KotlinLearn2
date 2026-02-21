package kotlinlearn.sort;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSorter {

  /**
   * Sorts a map by its values in descending order.
   *
   * @param map The map to sort.
   * @param <K> The type of keys.
   * @param <V> The type of values (must be Comparable).
   * @return A new LinkedHashMap sorted by value descending.
   */
  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValueDesc(Map<K, V> map) {
    return map.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

  /**
   * Sorts a map by its keys in ascending order.
   *
   * @param map The map to sort.
   * @param <K> The type of keys (must be Comparable).
   * @param <V> The type of values.
   * @return A new LinkedHashMap sorted by key ascending.
   */
  public static <K extends Comparable<? super K>, V> Map<K, V> sortByKeyAsc(Map<K, V> map) {
    return map.entrySet().stream()
        .sorted(Map.Entry.comparingByKey())
        .collect(
            Collectors.toMap(
                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
  }

  public static void main(String[] args) {
    Map<String, Integer> sample = new LinkedHashMap<>();
    sample.put("Alice", 3);
    sample.put("Bob", 5);
    sample.put("Charlie", 1);

    System.out.println("Original: " + sample);

    Map<String, Integer> sortedByValue = sortByValueDesc(sample);
    System.out.println("Sorted by Value Desc: " + sortedByValue);
    // Output: {Bob=5, Alice=3, Charlie=1}

    Map<String, Integer> sortedByKey = sortByKeyAsc(sample);
    System.out.println("Sorted by Key Asc: " + sortedByKey);
    // Output: {Alice=3, Bob=5, Charlie=1}
  }
}
