package nineteen.day1

import utils.readFileLines
import kotlin.math.floor

//https://adventofcode.com/2019/day/1
fun main(args: Array<String>) = readFileLines("resources/2019/day1.txt")
        .map { it.toFloat() }
        .requireNoNulls()
        .sumBy { (floor((it / 3)) - 2).toInt() }
        .let { print("Result: $it") }