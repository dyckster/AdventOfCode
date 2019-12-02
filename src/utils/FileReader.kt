package utils

import java.io.File
import java.io.InputStream

fun readFileLines(fileName: String): List<String> {
    val inputStream: InputStream = File(fileName).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    return lineList.toList()
}

fun readFile(fileName: String): String {
    val inputStream: InputStream = File(fileName).inputStream()
    return inputStream.bufferedReader().use { it.readText() }
}