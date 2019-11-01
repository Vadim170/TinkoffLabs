package ru.tinkoff.lab10_4

import java.util.HashSet

fun main() {
    val listSmeshariki = ArrayList<String>()
    listSmeshariki.addAll(arrayOf("Крош","Ежик","Нюша","Бараш"))
    val setSmeshariki = HashSet<String>()
    setSmeshariki.addAll(arrayOf("Крош","Ежик","Нюша","Бараш"))
    println("Список смешариков:")
    listSmeshariki.forEach { println(it) }
    println("Множество смешариков:")
    setSmeshariki.forEach { println(it) }
}
