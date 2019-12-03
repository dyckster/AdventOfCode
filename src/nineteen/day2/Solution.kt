package nineteen.day2

import utils.readFile
import java.util.*

private const val DELIMITER = ","

private const val CODE_ADD = 1
private const val CODE_MULTIPLY = 2
private const val CODE_FINISH = 99
private const val STEP_OFFSET = 4

private val OP_CODES = arrayOf(CODE_ADD, CODE_MULTIPLY, CODE_FINISH)

//https://adventofcode.com/2019/day/2
fun main(args: Array<String>) {
    val input = readFile("resources/2019/day2.txt")
            .split(DELIMITER)
            .map { it.trim().toInt() }
            .toTypedArray()
    println(Arrays.toString(input))

    var changedArray = input

    //Apply preconditions
    changedArray[1] = 12
    changedArray[2] = 2

    for (i in 0..input.size) {
        val currVal = changedArray[i]

        if (i % STEP_OFFSET != 0) continue
        if (currVal == CODE_FINISH) {
            println("Halting program...")
            break
        }

        changedArray = addValues(currVal, changedArray[i + 1], changedArray[i + 2], changedArray[i + 3], changedArray)
    }

    println(Arrays.toString(changedArray))
}


private fun addValues(code: Int, firstPos: Int, secondPos: Int, resultPos: Int, array: Array<Int>): Array<Int> {
    val first = array[firstPos]
    val second = array[secondPos]
    val result = when (code) {
        CODE_ADD -> first + second
        CODE_MULTIPLY -> first * second
        else -> throw IllegalArgumentException("Unsupported code! Must be one of: ${Arrays.toString(OP_CODES)}")
    }

    array[resultPos] = result

    return array
}
