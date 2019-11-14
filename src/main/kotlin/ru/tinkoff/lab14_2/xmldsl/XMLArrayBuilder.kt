package ru.tinkoff.lab14_2.xmldsl

class XMLArrayBuilder {
    private var result = mutableListOf<String>()

    operator fun String.unaryPlus() =
        result.add(this)

    fun toArray() =
        result.toTypedArray()
}