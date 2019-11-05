package ru.tinkoff.lab11_2_2

fun main() {
    val count = readLine()?.toInt()?:0
    val inputStr = readLine() ?: ""

    val nodes = mutableMapOf<Int,Int>()
    inputStr.split(" ").forEachIndexed { index, parent -> nodes.put(index, parent.toInt()) }

    val findNodes = mutableMapOf<Int,Int>()
    val lastestIndexes = mutableSetOf<Int>()
    var height = 0
    findNodes.putAll(nodes.filterValues { it == -1 })
    while (findNodes.isNotEmpty()) {
        val temp = mutableMapOf<Int,Int>()
        temp.putAll(findNodes)
        findNodes.clear()
        temp.forEach {
            val level = it.key
            if(!lastestIndexes.contains(level) && lastestIndexes.size < count) {
                lastestIndexes.add(level)
                findNodes.putAll(nodes.filterValues { it == level })
            }
        }
        ++height
    }
    println(height)
}