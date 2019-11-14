package ru.tinkoff.lab14_2.xmldsl

import java.lang.StringBuilder

class ObjectXML {
    var name: String? = null
    var supername: String? = null
    var birthDate: String? = null
    var addresses  = arrayOf<String>()

    override fun toString(): String {
        val result = StringBuilder()
        result.append("<object>\n")
        name?.let { result.append("\t<name>$name</name>\n") }
        supername?.let { result.append("\t<supername>$supername</supername>\n") }
        birthDate?.let { result.append("\t<birthDate>$birthDate</birthDate>\n") }
        if(addresses.isNotEmpty()) {
            result.append("\t<addresses>\n")
            addresses.forEach {
                result.append("\t\t<address>$it</address>\n")
            }
            result.append("\t<addresses>\n")
        }
        result.append("</object>")
        return result.toString()
    }
}