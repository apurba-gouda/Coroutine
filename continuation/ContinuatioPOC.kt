package com.example.networkmodule.continuation

import kotlinx.coroutines.*
import kotlin.coroutines.Continuation


//Suspend functions

class ContinuationPOC {


    /*
    * Resumes the execution of the corresponding coroutine passing a successful or failed result as the return
        value of the last suspension point.
    *
    * statement breakdown:
    * It provides a result value of the last suspension point  (result : success, failure)
    * And resumes the execution of another
    *
    * if the provided result is success then what is the behaviour and vice-versa
    *
    *
    * Kotlin compiler generates ________ for continuation object?
    * Kotlin compiler generates a state machine ?
    *
    * state = suspension point
    * 
    *
    * */



    fun fetchAndLoadProfile(userId: String) {
        MainScope().launch {
            val profileRes = fetchProfile(userId)
            loadProfile(profileRes)
        }
    }

    private suspend fun fetchProfile(userId: String): Any {
        return ""
    }

    fun loadProfile(profile: Any) {

    }


    /*How does withContext() makes a suspending fun a non-blocking suspending function. */







    suspend fun doSomething() {
        println("doSomething() started")
        val res1 = addValues(54, 87)
        val res2 = multiplyValues(24, 897)
        println("doSomething() finished")
    }

    private suspend fun addValues(val1: Int, val2: Int): Int {
        println("addValues() called")
        delay(5000)
        return val2 + val1
    }

    private suspend fun multiplyValues(val1: Int, val2: Int): Int {
        println("multiplyValues() called")
        delay(5000)
        return val2 * val1
    }

    suspend fun renderImage() {
        val path: String = getPath()
        val image = getImage(path)
        val clip = getClip(image)
        processImage(clip)
    }

    private fun processImage(clip: Any) {
    }

    private suspend fun getClip(image: String): String {
        delay(2000)
        return image
    }

    private suspend fun getImage(path: String): String {
        delay(3000)
        return path
    }

    private fun getPath(): String {
        return ""
    }

}