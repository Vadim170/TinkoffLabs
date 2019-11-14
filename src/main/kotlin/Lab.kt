package ru.tinkoff.lab11_2_3

import java.util.*

fun main() {
    val cin = Scanner(System.`in`)
    val sizeQueue = cin.nextInt()
    val countPockets = cin.nextInt()
    val taskQueue = ArrayDeque<Task>(sizeQueue)
    repeat(countPockets) {
        val arrivalTime = cin.nextInt()
        // Мы получили новое время, теперь проматываем все операции процессора до этого момента
        while(taskQueue.isNotEmpty()) {
            if(taskQueue.peek().isFinished(arrivalTime))
                taskQueue.poll()
            else break
        }
        val duration = cin.nextInt()
        val task = Task(duration)
        if(taskQueue.size >= sizeQueue)
            task.onSkip() // Буффер переполнен, пропускаем
        else {
            taskQueue.add(task)
            Processor.doTask(arrivalTime, task)
        }
    }
}

object Processor {
    var prevTask = Task(0)

    fun doTask(arrivalTime: Int, task: Task) {
        val startTime = if(prevTask.isFinished(arrivalTime)) arrivalTime
        else prevTask.getTimeRelease() // Время окончания обработки прошлой задачи оно же время начала следующей
        task.onStartDo(startTime)
        prevTask = task
    }
}

class Task(private val duration: Int) {
    private var timeRelease = 0

    fun getTimeRelease() = timeRelease

    fun onSkip() = println(-1)

    fun onStartDo(startTime: Int) {
        timeRelease = startTime + duration
        println(startTime)
    }

    fun isFinished(arrivalTime: Int) = timeRelease <= arrivalTime
}