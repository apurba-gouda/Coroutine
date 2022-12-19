package com.example.assignment.ui.coroutines.coroutinepoc.thread

import kotlin.concurrent.thread

class POCThread {
    fun useThread() {
        Thread {
            val t = Thread {
                var i = 0
                while (true) {
                    println("Child: I am working")
                    i++
                    Thread.sleep(10)
                }
            }
            t.start()
            Thread.sleep(30)
            println("Parent: I am working")
            t.stop()
        }.start()
    }
    fun doBackgroundTask() {
        thread {
            println("WorkerThread: Parent")
            startBackgroundTask(4)
            Thread.sleep(1000)
            throw Exception("Stop doesn't work")
        }
//        thread.start()// IllegalThreadStateException
//        thread.stop()
    }

    private fun startBackgroundTask(count: Int) {
        val threads = List(count) {
            val child = Thread()
            child.run {
                Thread.sleep(500)
                println("WorkerThread: $it  Child")

            }
            child
        }

        threads.forEach {
            it.start()
        }
    }
}