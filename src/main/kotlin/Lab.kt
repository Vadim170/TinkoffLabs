package ru.tinkoff.lab10_3

fun main() {
    val listSmeshariki = listOf("Крош","Ежик","Нюша","Бараш")
    val setSmeshariki = setOf("Крош","Ежик","Нюша","Бараш")
    println("Список смешариков:")
    listSmeshariki.forEach { println(it) }
    println("Множество смешариков:")
    setSmeshariki.forEach { println(it) }
}
