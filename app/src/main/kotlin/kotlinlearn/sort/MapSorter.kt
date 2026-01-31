package kotlinlearn.sort

// Extension function to sort map by value in descending order
// Works for any Map where values are Comparable
fun <K, V : Comparable<V>> Map<K, V>.sortByValueDesc(): Map<K, V> {
    return this.entries
        .sortedByDescending { it.value }
        .associate { it.toPair() }
}

// Extension function to sort map by key in ascending order
// Works for any Map where keys are Comparable
fun <K : Comparable<K>, V> Map<K, V>.sortByKeyAsc(): Map<K, V> {
    return this.entries
        .sortedBy { it.key }
        .associate { it.toPair() }
}

fun main() {
    val sample =
        mapOf(
            "Alice" to 3,
            "Bob" to 5,
            "Charlie" to 1,
        )

    // No need to instantiate a helper class
    val sortedByValue = sample.sortByValueDesc()

    println(sortedByValue)
    // Output: {Bob=5, Alice=3, Charlie=1}

    val sortedByKey = sample.sortByKeyAsc()
    println(sortedByKey)
    // Output: {Alice=3, Bob=5, Charlie=1}
}
