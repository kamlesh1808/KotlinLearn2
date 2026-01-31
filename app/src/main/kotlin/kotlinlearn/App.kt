package kotlinlearn

import kotlinlearn.array.KArray

fun main(args: Array<String>) {
    var stringA = arrayOf("one", "two", "three")

    stringA.forEachIndexed { i, value ->
        println("$i, $value")
    }

    var kArray = KArray()
    kArray.printArray(stringA)

    var listStr = listOf("seven", "eight", "nine")
    var listInts = listOf(7, 8, 9)

    kArray.printCollection(listStr)
    kArray.printCollection(listInts)
}
