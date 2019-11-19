package ru.tinkoff.lab15_2

fun main() {
    listOf("Хрюша", "Степаша", "Филя", "Гуля").firstOrNull { it.length > 6 }
}