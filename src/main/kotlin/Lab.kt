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
            if(Processor.isHaveTimeToDo(arrivalTime, taskQueue.peek()))
                Processor.doTask(arrivalTime, taskQueue.poll())
            else
                break
        }

        if(taskQueue.size >= size /*|| Processor.isInPast(arrivalTime)*/)
            Processor.onSkipTask() // Буффер переполнен
        else
            taskQueue.add(task)
    }

    while(taskQueue.isNotEmpty()) {
        Processor.doTask(0, taskQueue.poll())
    }
}

class Task(val arrivalTime: Int, val duration: Int) : Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return arrivalTime.compareTo(other.arrivalTime)
    }
}


object Processor {
    //private var actualTask: Task? = null
    //private var timeFormulationTask = 0
    private var timeRelease = 0

    fun isFree(nowTime: Int) : Boolean {
        return nowTime >= timeRelease
    }

    /*fun addTask(limitTime: Int, task: Task) {
        if (!isFree(limitTime)) return // Если текущая задача
        if (actualTask!=null) onDoActualTask()
        actualTask = task
        timeFormulationTask = limitTime
        timeRelease = limitTime + task.duration
    }

    fun onDoActualTask() {
        println(timeFormulationTask)
    }*/

    fun onSkipTask() {
        println(-1)
    }

    fun isHaveTimeToDo(arrivalTime: Int, task: Task): Boolean {
        return isFree(timeRelease + task.duration)
    }

    fun doTask(arrivalTime: Int, task: Task) {
        if (!isHaveTimeToDo(arrivalTime, task)) return
        println(timeRelease) // Время окончания обработки прошлой задачи оно же время начала следующей
        timeRelease += arrivalTime + task.duration
    }

    fun isInPast(arrivalTime: Int): Boolean {
        return !isFree(arrivalTime)
    }
}