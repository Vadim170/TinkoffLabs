package ru.tinkoff.lab12_3

fun main() {
    val names = listOf("�����","�������","����","����")
    val namesLengthLessSix = names.filter { it.length < 6 }
    println(namesLengthLessSix)
}