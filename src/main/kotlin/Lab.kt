package ru.tinkoff.lab10_5

fun main() {
    val listSmeshariki = listOf("Крош","Ежик","Нюша","Бараш")
    val destListSmeshariki = ArrayList<String>()
    listSmeshariki.forEach { destListSmeshariki.add(it) }
    println("Список смешариков:")
    destListSmeshariki.forEach { println(it) }
    val setSmeshariki = setOf("Крош","Ежик","Нюша","Бараш")
    val destSetSmeshariki = HashSet<String>()
    setSmeshariki.forEach { destSetSmeshariki.add(it) }
    println("Множество смешариков:")
    destSetSmeshariki.forEach { println(it) }
}
