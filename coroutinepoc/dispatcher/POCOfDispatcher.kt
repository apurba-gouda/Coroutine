package com.example.assignment.ui.coroutines.coroutinepoc.dispatcher

import kotlinx.coroutines.*


/*
* 1. CoroutineContext:
* 2. CoroutineScope
* 3. Dispatcher
* 4. Job
*
* CoroutineContext :
* */
class POCOfDispatcher {
    fun dispatcherDefault() {

        val scope = CoroutineScope(Dispatchers.Default)/* POC:  uses a thread pool of 4 threads */
        val job = scope.launch {

        }

        scope.launch (Dispatchers.Default){
            println("Thread: ${Thread.currentThread().name}")
            launch (job+Dispatchers.IO){
                println("Thread: ${Thread.currentThread().name}")
            }
        }

        val scope2 = MainScope()
        val res = scope + job   // Adding job to a scope, advantage ?
        val res1 = scope2 + job   // Adding job to a another scope, advantage ?
        val res2 = Dispatchers.IO + job   // Adding job to a dispatcher, advantage ?

    }

    fun main()  = runBlocking(Dispatchers.Main) {
        println("Thread: ${Thread.currentThread().name}")
    }

}