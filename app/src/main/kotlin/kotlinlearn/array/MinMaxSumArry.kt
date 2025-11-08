package kotlinlearn.array

class MinMaxSumArry {

	/**
	Given five positive integers, find the minimum and maximum values that can be calculated by summing exactly four of the five integers. Then print the respective minimum and maximum values as a single line of two space-separated long integers.

	For example, . Our minimum sum is  and our maximum sum is . We would print

	16 24
	 */
	fun miniMaxSum(arr: Array<Int>): Unit {
		var min: Long = 0
		var max: Long = 0
		var sum: Long = 0

		var index = 0
		for (n in arr) {
			sum = sum + n

			if (index == 0) {
				min = n.toLong()
				max = n.toLong()
				index++
			}

			if (n < min) {
				min = n.toLong()
			}

			if (n > max) {
				max = n.toLong()
			}
		}

		var minSum = sum - max
		var maxSum = sum - min


		println("$minSum $maxSum")

	}

}

fun main(args: Array<String>) {
	var app = MinMaxSumArry()
	app.miniMaxSum(arrayOf(1, 2, 3, 4, 5))
}