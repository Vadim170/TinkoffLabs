package ru.tinkoff.lab7_5

fun main() {
    // Создадим хозяина Pet
    val pet = Pet("Mary", 3, Sex.FEMALE)
    val owner = Owner(pet)
    owner.feed()
    // Создадим хозяина Dog
    val dog = Dog("Charly", 1)
    val dogOwner = Owner(dog)
    dogOwner.feed()
}

enum class Sex {
    MALE, FEMALE
}

open class Pet(
    val nickname: String,
    val age: Int,
    val sex: Sex? = null
)

class Dog(
    nickname: String,
    age: Int,
    sex: Sex? = null
) : Pet(nickname, age, sex)

class Cat(
    nickname: String,
    age: Int,
    sex: Sex? = null
) : Pet(nickname, age, sex)

fun Pet.isAddult() = age >= 2

val Pet.respectableNickname: String
    get() = "Dear ${this.nickname}"

class Owner<T : Pet>(val pet: T) {
    fun feed() = println("Домашнее животное ${pet.nickname} накормлено")
}
