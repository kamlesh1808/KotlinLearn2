package kotlinlearn.sort;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class MapSorterJTest {

  @Test
  public void sortsByValueDesc() {
    Map<String, Integer> sample = new HashMap<>();
    sample.put("Alice", 3);
    sample.put("Bob", 5);
    sample.put("Charlie", 1);

    // MapSorter is implemented in Kotlin; its class is kotlinlearn.sort.MapSorter
    MapSorterJ sorter = new MapSorterJ();
    Map<String, Integer> sorted = sorter.sortByValueDesc(sample);
    List<String> keys = new ArrayList<>(sorted.keySet());

    assertEquals(Arrays.asList("Bob", "Alice", "Charlie"), keys);
  }
}
