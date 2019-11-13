package ru.tinkoff.lab11_2_2

import java.util.*

class Node(val key: Int, val parent: Int)

var time = System.nanoTime() // Переменная для отсчета и вывода прошедшего времени
val nodes = mutableListOf<Node>() // Список всех узлов дерева

fun main() {
    // Пробовал вводить дерево из 200 узлов высотой 4,
    // split выполнялся примерно в 7 раз дольше остальной части алгоритма (split - 49 мс, вычисление высоты - 7 мс)
    //val rootKeys = inputUsingScanner() // Вариант без split с Scanner
    val rootKeys = inputUsingSplit() // Вариант c split
    println(calcHeightOfNodes(rootKeys))
    printElapsedMilliseconds()
}

/**
 * Вывод времени в миллисекундах с прошлого вызова или запуска программы
 */
private fun printElapsedMilliseconds() {
    println("${(System.nanoTime() - time) / 1_000_000} мс")
    time = System.nanoTime()
}

private fun inputUsingScanner(): List<Int> {
    val cin = Scanner(System.`in`)
    val count = cin.nextInt()
    val rootKeys = mutableListOf<Int>()
    repeat(count) { index ->
        val parent = cin.nextInt()
        val node = Node(index, parent)
        if (node.parent == -1) rootKeys.add(node.key)
        else nodes.add(node)
    }
    printElapsedMilliseconds()
    return rootKeys
}

private fun inputUsingSplit(): List<Int> {
    val count = readLine()?.toInt() ?: 0
    val inputStr = readLine() ?: ""
    printElapsedMilliseconds()
    val splitedStr = inputStr.split(' ')
    printElapsedMilliseconds()
    val rootKeys = mutableListOf<Int>()
    splitedStr.forEachIndexed { index, parent ->
        val node = Node(index, parent.toInt())
        if (node.parent == -1) rootKeys.add(node.key)
        else nodes.add(node)
    }
    return rootKeys
}

/**
 * Высчитывает высоту начиная с узлов с ключами принимаемыми в парметре [keys]
 */
private fun calcHeightOfNodes(keys: List<Int>): Int {
    if(keys.isEmpty()) return 0
    val keysOfChilds = keysOfChilds(keys)
    return 1 + calcHeightOfNodes(keysOfChilds)
}

/**
 * Находит список ключей детей для узлов, ключи которых переданы в параметре [parentsKeys]
 */
private fun keysOfChilds(parentsKeys: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    nodes.forEach {
        if(it.parent in parentsKeys) result.add(it.key)
    }
    return  result
}