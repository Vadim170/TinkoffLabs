package ru.tinkoff.lab11_2_3

import java.util.*

/*
2 8
0 0
0 0
0 0
1 0
1 0
1 1
1 2
1 3
Ответ: 0 0 0 1 1 1 2 -1

3 6
0 7
0 0
2 0
3 3
4 0
5 0
вывод: 0 7 7 -1 -1 -1

2 8
0 0
0 0
0 0
1 1
1 0
1 0
1 2
1 3

Ответ: 0 0 0 1 2 -1 -1 -1
 */

fun main() {
    val cin = Scanner(System.`in`)
    val sizeQueue = cin.nextInt()
    val countPockets = cin.nextInt()
    val taskQueue = PriorityQueue<Task>(sizeQueue)
    for (index in 0 until countPockets) {
        val arrivalTime = cin.nextInt()
        val duration = cin.nextInt()
        val task = Task(arrivalTime, duration)
        // Мы получили новое время, теперь проматываем все операции процессора до этого момента
        while(taskQueue.isNotEmpty()) {
            if(Processor.isFinished(arrivalTime, taskQueue.peek()))
                taskQueue.poll()
            /*else if(Processor.isHaveTimeToDo(arrivalTime, taskQueue.peek()))
                Processor.doTask(arrivalTime, taskQueue.peek())*/
            else
                break
        }
        if(taskQueue.size >= sizeQueue /*|| Processor.isInPast(arrivalTime)*/)
            Processor.onSkipTask() // Буффер переполнен
        else {
            taskQueue.add(task)
            Processor.doTask(arrivalTime, task)
        }
    }
    /*while(taskQueue.isNotEmpty()) {
        /*if(Processor.isFinished(Processor.timeRelease+1, taskQueue.peek()))
            taskQueue.poll()
        else*/
            Processor.doTask(0, taskQueue.poll())
    }*/
}

object Processor {
    private var actualTask: Task? = null
    //private var timeFormulationTask = 0
    var timeRelease = 0

    fun isFree(nowTime: Int) : Boolean {
        return nowTime + (actualTask?.duration ?: 0) >= timeRelease
    }

    fun onSkipTask() {
        println(-1)
    }

    fun isHaveTimeToDo(arrivalTime: Int, task: Task): Boolean {
        return isFree(arrivalTime/*timeRelease + task.duration*/)
    }

    fun doTask(arrivalTime: Int, task: Task) {
        //if (!isHaveTimeToDo(arrivalTime, task)) return
        if(timeRelease < arrivalTime)
            println(arrivalTime)
        else
            println(timeRelease) // Время окончания обработки прошлой задачи оно же время начала следующей
        //actualTask = task
        if(timeRelease < arrivalTime)
            timeRelease = arrivalTime + task.duration
        else
            timeRelease += /*arrivalTime*/ + task.duration
    }

    fun isInPast(arrivalTime: Int): Boolean {
        return !isFree(arrivalTime)
    }

    fun isFinished(arrivalTime: Int, task: Task): Boolean {
        return timeRelease + task.duration <= arrivalTime
    }
}

class Task(val arrivalTime: Int, val duration: Int) : Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return arrivalTime.compareTo(other.arrivalTime)
    }
}