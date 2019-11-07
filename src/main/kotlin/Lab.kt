package ru.tinkoff.lab12_4

fun main() {
    val names = listOf("Хрюша","Степаша","Филя","Гуля")
    var maxLength = 0
    names.forEach {
        if(it.length > maxLength)
            maxLength = it.length
    }
    val namesMaxLength = names.find { it.length == maxLength }
    println(namesMaxLength)
    // Тут логичнее применить не find, а maxBy :
    // names.maxBy { it.length }
    // А то приходится сначала искать максимальную длину пробегаясь по листу, потом пробегаться второй раз в find,
    // сравнивая длину с найденной ранее максимальной.
}