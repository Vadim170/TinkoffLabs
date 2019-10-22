
fun main() {
    listOf("three", "two", "one").forEach lit@{
        if(it == "one") {
            return@lit
            // т.к. forEach inline, то "return" не вызовет ошибку, он называется нелокальным
            // "retutn" без метки вызовет завершение функции main, а необходимо выйти из лямбды, для этого
            // используем "return@lit" чтобы вернуться к метке lit@
        }
        println(it)
    }
    println("boom!")
}