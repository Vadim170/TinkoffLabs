package ru.tinkoff.lab12_2

fun main() {
    val names = listOf("�����","�������","����","����")
    val helloNames = names.map{"������ $it"}
    println(helloNames)
}
