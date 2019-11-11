package ru.tinkoff.lab11_2_2

import java.util.*

fun main() {
    //System.`in` = BufferedInputStream("1 2 0 1 0 1 ".byteInputStream() )
    val cin = Scanner(System.`in`)
    val size = cin.nextInt()
    val countPockets = cin.nextInt()

    val taskQueue = PriorityQueue<Task>(size)
    for (index in 0 until countPockets) {
        val arrivalTime = cin.nextInt()
        val duration = cin.nextInt()
        val task = Task(arrivalTime, duration)

        // Мы получили новое время, теперь проматываем все операции процессора до этого момента
        while(taskQueue.isNotEmpty()) {
            if(Processor.isFree(arrivalTime))
                Processor.addTask(arrivalTime, taskQueue.poll())
            else {
                taskQueue.poll()
                Processor.onSkipTask()
            }
        }


        if(taskQueue.size >= size) {
            Processor.onSkipTask()
            continue
        } // Буффер переполнен
        else(taskQueue.add(task))
    }
}

class Task(val arrivalTime: Int, val duration: Int)

object Processor {
    private var timeFormulationTask = 0
    private var timeRelease = 0
    private var actualTask: Task? = null
    fun isFree(nowTime: Int) : Boolean {
        return nowTime >= timeRelease
    }

    fun addTask(nowTime: Int, task: Task) {
        if (!isFree(nowTime)) return
        if (actualTask!=null) onDoActualTask()
        actualTask = task
        timeFormulationTask = nowTime
        timeRelease = nowTime + task.duration
    }

    fun onDoActualTask() {
        println(timeFormulationTask)
    }

    fun onSkipTask() {
        println(-1)
    }
}