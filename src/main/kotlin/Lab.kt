package ru.tinkoff.lab8_6

import kotlinx.coroutines.*
import java.time.Duration

suspend fun main() {
    val pets = arrayListOf(
        Pet("Пёс", Duration.ofSeconds(1)),
        Pet("Вася", Duration.ofSeconds(4)),
        Pet("Бобик", Duration.ofSeconds(3)),
        Pet("Тотоша", Duration.ofSeconds(1)),
        Pet("Барс", Duration.ofSeconds(2))
    )

    // Задание 1
    println("Задание 1:")
    runBlocking {
        pets.forEach {
            launch { it.eat() }
        }
    }
    println("Животные накормлены")

    // Задание 2
    println("Задание 2:")
    val globalScope = GlobalScope.async {
        pets.forEach {
            launch { it.eat() }
        }
    }
    println("Еда роздана")
    globalScope.await()
    println("Животные накормлены")
}

class Pet(
    val nickName: String,
    val mealDuration: Duration = Duration.ZERO
) {
    suspend fun eat() {
        delay(mealDuration.toMillis())
        println("$nickName покушал")
    }
}