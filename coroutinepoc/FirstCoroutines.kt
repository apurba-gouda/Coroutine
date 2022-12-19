package com.example.assignment.ui.coroutines.coroutinepoc

import android.util.Log
import kotlinx.coroutines.*
import java.lang.Thread.sleep
import kotlin.concurrent.thread

/*
* Coroutine Context: is a set of various element (Job, and its Dispatcher)
*
* */
class FirstCoroutines {

    fun runBlockingTest() = runBlocking {
        val job: Job = launch {
            var i = 0
            while (true) {
                println("Child: I am working")
                i++
                delay(10)
            }
        }
        delay(30)
        println("Parent: I am working")
        job.cancel()
    }

    fun main() {
        CoroutineScope(Dispatchers.IO).launch {
            val job: Job = launch {
                var i = 0
                while (true) {
                    println("Child: I am working")
                    i++
                    delay(10)
                }
            }
            delay(30)
            println("Parent: I am working")
            job.cancel()
        }
    }

    fun mainAsync() {
        runBlocking {
            var count = 0

//            repeat(1){
//             val asyncJobParent = launch (Dispatchers.Main) {
//                   // delay(10)
//                 println(" Thread = ${Thread.currentThread().name}")
//                 count +it
//                }
//            }

            /*
            * Thread = DefaultDispatcher-worker-1
            * Thread = DefaultDispatcher-worker-1
            * Main Dispatcher is not working in the above condition.
            *
            *
            * */

            val asyncJob: Deferred<Int> = async(Dispatchers.Default) {
                delay(500)
                println("Thread = ${Thread.currentThread().name}")
                5
            }

            val asyncJob2: Deferred<Int> = async(Dispatchers.IO) {
                delay(1000)
                throw Exception("Some exception")
                println("Thread = ${Thread.currentThread().name}")
                7
            }
            try {
                val result = asyncJob.await() + asyncJob2.await()
                println("Result = $result  Thread = ${Thread.currentThread().name}")
            } catch (e: Exception) {
                Log.i("TAG", "mainAsync: $e")
            }

            /*
            * Even after handling the exception still the code breaks.
            * Application crashed.
            * */

        }

    }




}