package kotlinlearn.sort

class MapSorter {
    fun sortByValueDesc(map: Map<String, Int>): Map<String, Int> {
        return map.entries
            .sortedByDescending { it.value }
            .associate { it.key to it.value }
    }
}

fun main() {
    val sample = mapOf(
        "Alice" to 3,
        "Bob" to 5,
        "Charlie" to 1
    )

    val sorter = MapSorter()
    val sorted = sorter.sortByValueDesc(sample)

    println(sorted)
    // Output: {Bob=5, Alice=3, Charlie=1}
}
