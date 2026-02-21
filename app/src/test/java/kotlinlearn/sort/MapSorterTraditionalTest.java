package kotlinlearn.sort;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;
import org.junit.jupiter.api.Test;

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
