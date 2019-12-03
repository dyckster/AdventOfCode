package nineteen.day3

import utils.readFile
import utils.readFileLines

private const val DELIMITER = ","

fun main(args: Array<String>) {
    val wires = readFileLines("resources/2019/day3test.txt")
            .map { it.split(DELIMITER).map { parseCommand(it) } }
//    val commands = readFile("resources/2019/day3.txt")
//            .split(DELIMITER)
//            .map { parseCommand(it) }

    val wirePaths: MutableList<MutableList<Point>> = ArrayList()
    for (i in 0 until wires.size) {
        wirePaths.add(mutableListOf(Point(0, 0)))
    }

    for (i in 0 until wirePaths.size) {
        wires[i].forEach {
            val lastPoint = wirePaths[i].last()
            val newPoint = when (it.direction) {
                Direction.UP -> Point(lastPoint.x, lastPoint.y + it.length)
                Direction.DOWN -> Point(lastPoint.x, lastPoint.y - it.length)
                Direction.LEFT -> Point(lastPoint.x - it.length, lastPoint.y)
                Direction.RIGHT -> Point(lastPoint.x + it.length, lastPoint.y)
            }
            wirePaths[i].add(newPoint)
        }
    }
//
//    for (coordinate in coordinates.withIndex()) {
//        checkForCrossing(coordinate.value to coordinates[coordinate.index + 1], coordinates)
//    }

    println(wirePaths)
}

private fun checkForCrossing(line: Pair<Point, Point>, points: List<Point>) {
    for (p in points.withIndex()) {
        val thisLine = p.value to points[p.index + 1]

        if (thisLine.first.x in line.first.x..line.second.x && thisLine.second.x in line.first.x..line.second.x) {
            println("Crosses vertically")
        }

    }
}


private data class Command(val direction: Direction, val length: Long)
private data class Point(val x: Long, val y: Long)
private enum class Direction { UP, DOWN, LEFT, RIGHT }

private fun parseCommand(command: String): Command {
    val direction = Direction.values().find { it.name.first() == command.first() }
            ?: throw IllegalArgumentException("Failed to parse direction")
    val length = command.drop(1).toLong()

    return Command(direction, length)
}
