package ru.tinkoff.lab11_2_2

import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.InputStream
import java.util.*

fun main() {
    System.`in` = BufferedInputStream("1 2 0 1 0 1 ".byteInputStream() )
    val cin = Scanner(System.`in`)
    val size = cin.nextInt()
    val countPockets = cin.nextInt()

    val taskQueue = PriorityQueue<Task>(size)
    for (index in 0 until countPockets) {
        val arrivalTime = cin.nextInt()
        val duration = cin.nextInt()


        if(taskQueue.size >= size) {
            println(-1)
            continue
        } // Буффер переполнен
        else(taskQueue.add(Task(arrivalTime, duration)))

        // Мы получили новое время, теперь проматываем все операции процессора до этого момента
        while(taskQueue.isNotEmpty() && Processor.isFree(arrivalTime)) {
            Processor.addTask(arrivalTime, taskQueue.poll())
        }
    }
    Processor.doActualTask()


}

class Task(val arrivalTime: Int, val duration: Int)

object Processor {
    //private var timeFormulationTask = 0
    private var timeRelease = 0
    private var actualTask: Task? = null
    fun isFree(nowTime: Int) : Boolean {
        return nowTime >= timeRelease
    }

    fun addTask(nowTime: Int, task: Task) {
        if (!isFree(nowTime)) return
        if (actualTask!=null) println(timeRelease)
        actualTask = task
        timeRelease = nowTime + task.duration
    }

    fun doActualTask() {
        println(timeRelease)
    }
}