package ru.tinkoff.lab11_2_2

import java.util.*

class Node(val value: Int, val parent: Int)

val nodes = mutableListOf<Node>()
fun main() {
    /*val cin = Scanner(System.`in`)
    val count = cin.nextInt()
    val root = mutableListOf<Int>()
    repeat(count) { index ->
        val parent = cin.nextInt()
        val node = Node(index, parent)
        nodes.add(node)
        if(node.parent == -1) root.add(node.value)
    }*/

    val count = readLine()?.toInt()?:0
    val inputStr = readLine() ?: ""
    val time = System.nanoTime()
    println(System.nanoTime() - time)
    val splitedStr = inputStr.split(' ')
    println(System.nanoTime() - time)
    val root = mutableListOf<Int>()
    splitedStr.forEachIndexed { index, parent ->
        val node = Node(index, parent.toInt())
        nodes.add(node)
        if(node.parent == -1) root.add(node.value)
    }

    println(calcHeightOfNodes(root))
    println(System.nanoTime() - time)
}


fun calcHeightOfNodes(keys: List<Int>): Int {
    if(keys.isEmpty()) return 0
    val keysOfChilds = keysOfChilds(keys)
    return 1 + calcHeightOfNodes(keysOfChilds)
}

private fun keysOfChilds(parentsKeys: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    nodes.forEach { if(it.parent in parentsKeys) result.add(it.value) }
    return  result
}