package nineteen.day3

import utils.readFileLines
import kotlin.math.abs

private const val DELIMITER = ","
private val MIDDLE_POINT = Point(0, 0)

fun main(args: Array<String>) {
    val wires = readFileLines("resources/2019/day3.txt")
            .map { it.split(DELIMITER).map { parseCommand(it) } }

    val points: MutableMap<Point, MutableSet<Step>> = HashMap()
    val wirePaths: MutableList<MutableList<Point>> = ArrayList()

    for (i in 0 until wires.size) {
        wirePaths.add(mutableListOf(MIDDLE_POINT))
    }

    for (i in 0 until wirePaths.size) {
        var step = 0
        wires[i].forEachIndexed { _, command ->
            val lastPoint = wirePaths[i].last()
            val newPoint = when (command.direction) {
                Direction.UP -> Point(lastPoint.x, lastPoint.y + command.length)
                Direction.DOWN -> Point(lastPoint.x, lastPoint.y - command.length)
                Direction.LEFT -> Point(lastPoint.x - command.length, lastPoint.y)
                Direction.RIGHT -> Point(lastPoint.x + command.length, lastPoint.y)
            }

            when (command.direction) {
                Direction.UP -> {
                    for (y in lastPoint.y..newPoint.y) {
                        addBetweenPoints(i, step++, Point(lastPoint.x, y), points)
                    }
                }
                Direction.DOWN -> {
                    for (y in lastPoint.y downTo newPoint.y) {
                        addBetweenPoints(i, step++, Point(lastPoint.x, y), points)
                    }
                }
                Direction.RIGHT -> {
                    for (x in lastPoint.x..newPoint.x) {
                        addBetweenPoints(i, step++, Point(x, lastPoint.y), points)
                    }
                }
                Direction.LEFT -> {
                    for (x in lastPoint.x downTo newPoint.x) {
                        addBetweenPoints(i, step++, Point(x, lastPoint.y), points)
                    }
                }
            }

            wirePaths[i].add(newPoint)
            step--
        }
    }

    val shortestDistance = points
            .filterKeys { it != MIDDLE_POINT }
            .filterValues { it.map { it.wireId }.distinct().size > 1 }.keys
            .map { calculateManhattanDistance(MIDDLE_POINT, it) }
            .min()

    val shortestByStep = points
            .filterKeys { it != MIDDLE_POINT }
            .filterValues { it.map { it.wireId }.distinct().size > 1 }.values
            .map { it.sumBy { it.step } }
            .min()

    println("Solution 1: $shortestDistance")
    println("Solution 2: $shortestByStep")
}

private fun addBetweenPoints(wireId: Int,
                             step: Int,
                             newPoint: Point,
                             points: MutableMap<Point, MutableSet<Step>>) {
    val stepObj = Step(wireId, step)
    points.merge(newPoint, mutableSetOf(stepObj)) { old, new ->

        old.add(new.first())
        return@merge old
    }
}

private enum class Direction { UP, DOWN, LEFT, RIGHT }
private data class Command(val direction: Direction, val length: Long)
private data class Step(val wireId: Int, val step: Int)
private data class Point(val x: Long, val y: Long) {
    override fun toString() = "P{$x:$y}"
}

private fun calculateManhattanDistance(pointA: Point, pointB: Point): Long {
    return abs(pointA.x - pointB.x) + abs(pointA.y - pointB.y)
}

private fun parseCommand(command: String): Command {
    val direction = Direction.values().find { it.name.first() == command.first() }
            ?: throw IllegalArgumentException("Failed to parse direction")
    val length = command.drop(1).toLong()

    return Command(direction, length)
}
