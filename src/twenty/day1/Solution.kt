package twenty.day1


import utils.readFile
import java.lang.NullPointerException

private const val DELIMITER = "\r\n"
private const val DESIRED_RESULT = 2020

fun main(args: Array<String>) {
    val start = System.currentTimeMillis()
    val input = getInput()
    var result: DesiredPair? = null

    for (number in input) {
        result = tryToFindTheResult(input = input, currentNumber = number)
        if (result != null) {
            break
        }
    }
    if (result == null) {
        throw NullPointerException("Failed to get result :(")
    }

    val finalResult = result.firstValue * result.secondValue
    println("Lucky numbers: $result")
    println("Final result: $finalResult")
    println("Took: ${System.currentTimeMillis() - start}")
}

private fun tryToFindTheResult(input: Array<Int>, currentNumber: Int): DesiredPair? {
    for (number in input) {
        if (number + currentNumber == DESIRED_RESULT) {
            return DesiredPair(number, currentNumber)
        }
    }
    return null
}

private data class DesiredPair(val firstValue: Int, val secondValue: Int)

private fun getInput(): Array<Int> {
    return readFile("resources/2020/day1.txt")
            .split(DELIMITER)
            .map { it.trim().toInt() }
            .toTypedArray()
}