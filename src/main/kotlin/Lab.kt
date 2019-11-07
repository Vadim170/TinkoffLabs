package ru.tinkoff.lab12_3

fun main() {
    val names = listOf("Хрюша","Степаша","Филя","Гуля")
    val namesLengthLessSix = names.filter { it.length < 6 }
    println(namesLengthLessSix)
}