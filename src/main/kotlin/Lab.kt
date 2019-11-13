package ru.tinkoff.lab11_2_3

import java.util.*
import java.util.stream.Stream

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

1 5
999999 1
1000000 0
1000000 1
1000000 0
1000000 0

Ответ: 999999 1000000 1000000 -1 -1

4 5
0 7
2 7
4 7
6 7
21 7

Ответ? 7 14 21 28 35
 */

fun main() {
    val cin = Scanner(System.`in`)
    val sizeQueue = cin.nextInt()
    val countPockets = cin.nextInt()
    val taskQueue = PriorityQueue<Task>(sizeQueue)
    var prevTask = Task(0,0)
    for (index in 0 until countPockets) {
        val arrivalTime = cin.nextInt()
        val duration = cin.nextInt()
        val task = Task(arrivalTime, duration)
        // Мы получили новое время, теперь проматываем все операции процессора до этого момента
        while(taskQueue.isNotEmpty()) {
            if(taskQueue.peek().isFinished(arrivalTime))
                taskQueue.poll()
            else
                break
        }
        if(taskQueue.size >= sizeQueue)
            Processor.onSkipTask() // Буффер переполнен
        else {
            taskQueue.add(task)
            Processor.doTask(arrivalTime, task, prevTask)
            prevTask = task
        }
    }
}

object Processor {
    var outStream : Stream = System.out
    fun onSkipTask() = println(-1)
    private fun onDoTask(time: Int) = println(time)

    fun doTask(arrivalTime: Int, task: Task, prevTask: Task) {
        onDoTask(
            if(prevTask.timeRelease < arrivalTime) arrivalTime
            else prevTask.timeRelease // Время окончания обработки прошлой задачи оно же время начала следующей
        )
        if(prevTask.timeRelease < arrivalTime)
            task.timeRelease = arrivalTime + task.duration
        else
            task.timeRelease = prevTask.timeRelease + task.duration
    }
}

class Task(val arrivalTime: Int, val duration: Int) : Comparable<Task> {
    var timeRelease = 0
    override fun compareTo(other: Task): Int {
        return arrivalTime.compareTo(other.arrivalTime)
    }
    fun isFinished(arrivalTime: Int) : Boolean {
        return timeRelease <= arrivalTime
    }
}