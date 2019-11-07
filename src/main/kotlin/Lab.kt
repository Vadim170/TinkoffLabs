package ru.tinkoff.lab12_5

fun main() {
    val names = listOf("Хрюша","Степаша","Филя","Гуля")
    val isExistNamesLengthMoreSeven = names.any { it.length == 7 }
    if(isExistNamesLengthMoreSeven)
        println("Есть имена длинной семь символов")
    else
        println("Нет имен длинной семь символов")
}