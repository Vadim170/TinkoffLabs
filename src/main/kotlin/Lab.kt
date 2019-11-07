package ru.tinkoff.lab12_7

fun main() {
    val names = listOf("Хрюша","Степаша","Филя","Гуля")
    val helloNamesLengthLessFive = names.asSequence()
        .filter { it.length < 5 }
        .map { "Привет $it" }
        .toList()
    println(helloNamesLengthLessFive)
}