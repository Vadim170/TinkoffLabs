package ru.tinkoff.lab5_7

import com.google.common.collect.ComparisonChain
import java.lang.StringBuilder

data class Person (
    val lastName: String,
    val firstName: String,
    val age: Int,
    val mailId: Int,
    val phoneNumber: String
) {
    companion object : Comparator<Person>{
        override fun compare(o1: Person?, o2: Person?): Int {
            if(o1 == null || o2 == null) return 0
            return ComparisonChain.start()
                .compare(o1.lastName, o2.lastName)
                .compare(o1.firstName, o2.firstName)
                .compare(o1.age, o2.age)
                .compare(o1.mailId, o2.mailId)
                .compare(o1.phoneNumber, o2.phoneNumber)
                .result()
        }
    }
}

object PersonsComparator : Comparator<Person> {
    override fun compare(o1: Person?, o2: Person?): Int {
        if(o1 == null || o2 == null) return 0
        return ComparisonChain.start()
            .compare(o1.lastName, o2.lastName)
            .compare(o1.firstName, o2.firstName)
            .compare(o1.age, o2.age)
            .compare(o1.mailId, o2.mailId)
            .compare(o1.phoneNumber, o2.phoneNumber)
            .result()
    }
}

fun stringComparePersons(person1: Person, person2: Person, comparator: Comparator<Person>): String {
    val isIdentical = comparator.compare(person1, person2) == 1
    return "${person1.firstName} ${if (isIdentical) "identical" else "not identical"} ${person2.firstName}"
}

fun compareThreePerson(
    person1: Person,
    person2: Person,
    person3: Person,
    comparator: Comparator<Person>
)  = StringBuilder()
        .appendln(stringComparePersons(person1,person2, comparator))
        .appendln(stringComparePersons(person1,person3, comparator))
        .append(stringComparePersons(person2,person3, comparator))
        .toString()

fun main() {
    val person1 = Person("Иванов", "Семён", 17, 330045, "+79209826345")
    val person2 = Person("Алёхин", "Виктор", 23, 330045, "+79219821315")
    val person3 = Person("Иванов", "Семён", 17, 330045, "+79209826345")
    val output = StringBuilder()
    output.appendln("Compare by PersonsComparator object:")
    output.appendln(compareThreePerson(person1, person2, person3, PersonsComparator))
    output.appendln("Compare by companion object:")
    output.appendln(compareThreePerson(person1, person2, person3, Person))
    println(output)
}