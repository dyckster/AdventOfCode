package nineteen.day2

import utils.readFile
import java.util.*

private const val DELIMITER = ","

private const val CODE_ADD = 1
private const val CODE_MULTIPLY = 2
private const val CODE_FINISH = 99

private val OP_CODES = arrayOf(CODE_ADD, CODE_MULTIPLY, CODE_FINISH)

//https://adventofcode.com/2019/day/2
fun main(args: Array<String>) {
    val input = readFile("resources/2019/day2.txt")
            .split(DELIMITER)
            .map { it.trim().toInt() }
            .toTypedArray()
    var changedArray = input
    for (i in input.withIndex()) {
        if (changedArray[i.index] == CODE_FINISH) {
            println("Finishing...")
            break
        }
        if (changedArray[i.index] % 4 != 0) continue
        val code = changedArray[i.index]
        val firstPos = changedArray[i.index + 1]
        val secondPos = changedArray[i.index + 2]
        val finalPos = changedArray[i.index + 3]

        println("Code: $code")
//        println("First value position: $firstPos")
//        println("Second value position: $secondPos")
//        println("Final value position: $finalPos")

        changedArray = when (code) {
            CODE_ADD -> addValues(firstPos, secondPos, finalPos, changedArray)
            CODE_MULTIPLY -> multiplyValues(firstPos, secondPos, finalPos, changedArray)
            else -> changedArray
        }
    }
    println(Arrays.toString(input))
    println(Arrays.toString(changedArray))
}


private fun addValues(firstPos: Int, secondPos: Int, resultPos: Int, array: Array<Int>): Array<Int> {
    array[resultPos] = array[firstPos].plus(array[secondPos])
    return array
}


private fun multiplyValues(firstPos: Int, secondPos: Int, resultPos: Int, array: Array<Int>): Array<Int> {
    array[resultPos] = array[firstPos].times(array[secondPos])
    return array
}