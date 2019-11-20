package ru.tinkoff.lab11_2_2

import java.util.*

val parents = mutableMapOf<Int, MutableList<Int>>() // Key - родитель; Value - список его детей

fun main() {
    val cin = Scanner(System.`in`)
    val count = cin.nextInt()
    repeat(count) { value ->
        val parent = cin.nextInt()
        if(parents.containsKey(parent)) parents[parent]?.add(value) // Если список с детьми этого родителя уже есть в мапе, то добавим ребенка
        else parents[parent] = mutableListOf(value) // Если родителя ещё нет в мапе, то создадим элемент и список с одним ребёнком
    }
    parents[-1]?.let {
        println(calcHeightOfNodes(it))
    }
}

private fun calcHeightOfNodes(keys: List<Int>): Int {
    if(keys.isEmpty()) return 0
    val keysOfChilds = keysOfChilds(keys)
    return 1 + calcHeightOfNodes(keysOfChilds)
}

private fun keysOfChilds(parentsKeys: List<Int>) =
    parents.asSequence()
        .filter { it.key in parentsKeys }
        .flatMap { it.value.asSequence() }
        .toList()

