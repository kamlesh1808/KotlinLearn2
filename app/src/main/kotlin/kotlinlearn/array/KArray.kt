package kotlinlearn.array

class KArray {

	fun printArray(c: Array<Any>) {
		println("printArray")
		for ((i, value) in c.withIndex()) {
			println("$i, $value")
		}
	}

	fun printCollection(c: Collection<Any>) {
		println("printCollection")
		for ((i, value) in c.withIndex()) {
			println("$i, $value")
		}
	}
}

fun main(args: Array<String>) {
	println("Printing args")

	for (a in args) {
		println(a)
	}

	println("Printing args forEach")
	args.forEach { println(it) }

	var intA = intArrayOf(1, 2, 3, 4, 6, 7)

	for (i in intA) {
		println(i)
	}

	for ((i, value) in intA.withIndex()) {
		println("$i, $value")
	}

	intA.forEach { println(it) }

	intA.forEachIndexed { i, value ->
		println("$i, $value")
	}

	var stringA = arrayOf("one", "two", "three")
	stringA.forEachIndexed { i, value ->
		println("$i, $value")
	}


	var kArray = KArray();
	kArray.printArray(stringA as Array<Any>)

	var listStr = listOf("seven", "eight", "nine")
	var listInts = listOf(7, 8, 9)
	
	kArray.printCollection(listStr as Collection<Any>)
	kArray.printCollection(listInts as Collection<Any>)


}