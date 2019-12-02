package utils

import java.io.File
import java.io.InputStream

fun readFile(fileName: String): List<String> {
    val inputStream: InputStream = File(fileName).inputStream()
    val lineList = mutableListOf<String>()

    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it) } }

    return lineList.toList()
}