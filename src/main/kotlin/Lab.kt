package ru.tinkoff.lab12_5

fun main() {
    val names = listOf("�����","�������","����","����")
    val isExistNamesLengthMoreSeven = names.any { it.length == 7 }
    if(isExistNamesLengthMoreSeven)
        println("���� ����� ������� ���� ��������")
    else
        println("��� ���� ������� ���� ��������")
}