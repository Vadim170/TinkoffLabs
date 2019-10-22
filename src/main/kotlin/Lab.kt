package ru.tinkoff.lab8_5

fun main() {
    listOf("three", "two", "one").forEach {
        if(it == "one") {
            return@forEach
            // т.к. forEach inline, то "return" не вызовет ошибку, он называется нелокальным
            // "retutn" без метки вызовет завершение функции main, а необходимо выйти из лямбды, для этого
            // используем "return@forEach" чтобы вернуться локально к циклу forEach
            // Ещё можно сделать лямбду ананонимной функцией, тогда return менять не надо
        }
        println(it)
    }
    println("boom!")
}