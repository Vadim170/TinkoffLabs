package ru.tinkoff.lab11_2_1

import java.util.*

fun main() {
    val inputStr = readLine() ?: ""
    if(inputStr.length <= 100_000) {
        val stackErrorParentheses = getStackOfErrorParentheses(inputStr)
        val result = getIndexLastClosableOrFirstOpeningParentheses(stackErrorParentheses)
        println(
            when (result) {
                0 -> "Success"
                else -> result
            }
        )
    }
}

private fun getStackOfErrorParentheses(
    inputStr: String
): Stack<Pair<Char, Int>> {
    val pairsOfParentheses = mapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']')
    val stackResult = Stack<Pair<Char, Int>>()
    inputStr.forEachIndexed { index, c ->
        if(c in arrayOf('(',')','{','}','[',']'))
            if(stackResult.isNotEmpty() && pairsOfParentheses[stackResult.peek().first] == c)
                stackResult.pop()
            else stackResult.push(Pair(c, index+1))
    }
    return stackResult
}

private fun getIndexLastClosableOrFirstOpeningParentheses(
    stackForCheck: Stack<Pair<Char, Int>>
) :Int {
    if(stackForCheck.isEmpty()) return 0
    val openingParentheses = setOf('(','{','[')
    val closingParentheses = setOf(')','}',']')
    var indexFirstClosingParentheses = 0
    var indexFirstOpeningParentheses = 0
    while (stackForCheck.isNotEmpty()) {
        when(stackForCheck.peek().first) {
            in closingParentheses -> indexFirstClosingParentheses = stackForCheck.pop().second
            in openingParentheses -> indexFirstOpeningParentheses = stackForCheck.pop().second
        }
    }
    if(indexFirstClosingParentheses != 0) return indexFirstClosingParentheses
    return indexFirstOpeningParentheses
}