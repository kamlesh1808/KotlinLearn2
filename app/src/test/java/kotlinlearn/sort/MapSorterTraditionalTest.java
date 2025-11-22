package kotlinlearn.sort;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MapSorterTraditionalTest {

  @Test
  void sortsByValueDesc() {
    var sample = new HashMap<String, Integer>();
    sample.put("Alice", 3);
    sample.put("Bob", 5);
    sample.put("Charlie", 1);

    var sorted = MapSorterTraditional.sortByValueDesc(sample);
    var keys = new ArrayList<>(sorted.keySet());

    assertEquals(Arrays.asList("Bob", "Alice", "Charlie"), keys);
  }
}

