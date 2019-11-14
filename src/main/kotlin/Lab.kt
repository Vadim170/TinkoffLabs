package ru.tinkoff.lab14_2

import ru.tinkoff.lab14_2.xmldsl.*

fun main() {
    val myObjectXML = objectXML {
        name = "Имя"
        supername = "Имя"
        birthDate = "13.02.2019"
        addresses {
            +"Пример адреса"
            +"Пример адреса"
            +"Пример адреса"
        }
    }
    println(myObjectXML)
}

