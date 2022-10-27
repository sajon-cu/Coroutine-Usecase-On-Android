package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlinx.coroutines.*

/**
 * Created by sajon on 10/26/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

fun main() = runBlocking { // block the main thread
    println("main starts")

    /**
     * Note: coroutine - Cooperative Routine
     * Coroutine can pass the current control flow
     * back and forth with other coroutine for achieving concurrency
    */
    // wait for all the coroutine has finished
    joinAll(
        /**
         * async is a special coroutine builder that start a new coroutine
         */
        async { threadSwitchingCoroutine(1, 500) }, // this will start the coroutines at the same time
        async { threadSwitchingCoroutine(2, 300) }  // this will start the coroutines at the same time
    )

    println("main ends")
}

/**
 * Note: suspend function is
 * a special function that perform some long running operation(s)
 * and can be suspended or paused and continued at a later point of time.
 * suspend function can only be called from other suspend function or from a coroutine
 * suspend function can be paused at "Suspension point"
 */
suspend fun threadSwitchingCoroutine(number: Int, delayInMillis: Long) {
    println("Coroutine $number starts work on ${ Thread.currentThread().name }")
    delay(delayInMillis) // suspends or pauses the coroutine for the specified amount of time

    withContext(Dispatchers.Default) { //
        println("Coroutine $number has finished on ${ Thread.currentThread().name }")
    }
}