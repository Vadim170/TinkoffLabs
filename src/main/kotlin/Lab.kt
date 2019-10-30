package ru.tinkoff.lab8_6

import kotlinx.coroutines.*
import java.time.Duration

suspend fun main() {
    val pets = ArrayList<Pet>()
    pets.apply {
        add(Pet("Пёс", Duration.ofSeconds(1)))
        add(Pet("Вася", Duration.ofSeconds(4)))
        add(Pet("Бобик", Duration.ofSeconds(3)))
        add(Pet("Тотоша", Duration.ofSeconds(1)))
        add(Pet("Барс", Duration.ofSeconds(2)))
    }

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
    GlobalScope.launch {
        val result = async {
            pets.forEach {
                launch { it.eat() }
            }
        }
        launch{
            result.await()
            println("Животные накормлены")
        }
    }
    println("Еда роздана")
    Thread.sleep(5000) // Даю время для завершения фонового потока корутины.
}

class Pet(
    val nickName: String,
    val mealDuration: Duration = Duration.ZERO) {
    suspend fun eat() {
        delay(mealDuration.toMillis())
        println("$nickName покушал")
    }
}