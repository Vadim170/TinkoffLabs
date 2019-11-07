package ru.tinkoff.lab12_2

fun main() {
    val names = listOf("Хрюша","Степаша","Филя","Гуля")
    val helloNames = names.map{"Привет $it"}
    println(helloNames)
}
