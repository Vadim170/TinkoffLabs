package ru.tinkoff.lab12_4

fun main() {
    val names = listOf("�����","�������","����","����")
    var maxLength = 0
    names.forEach {
        if(it.length > maxLength)
            maxLength = it.length
    }
    val namesMaxLength = names.find { it.length == maxLength }
    println(namesMaxLength)
    // ��� �������� ��������� �� find, � maxBy :
    // names.maxBy { it.length }
    // � �� ���������� ������� ������ ������������ ����� ���������� �� �����, ����� ����������� ������ ��� � find,
    // ��������� ����� � ��������� ����� ������������.
}