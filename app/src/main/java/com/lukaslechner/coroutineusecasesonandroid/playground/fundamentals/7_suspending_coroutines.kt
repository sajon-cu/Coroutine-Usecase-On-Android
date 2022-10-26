package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.runBlocking

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
        async { suspendingCoroutine(1, 500) }, // this will start the coroutines at the same time
        async { suspendingCoroutine(2, 300) },  // this will start the coroutines at the same time
        async {
            repeat(5) {
                println("other task is working on ${Thread.currentThread().name}")
                delay(100)
            }
        }
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
suspend fun suspendingCoroutine(number: Int, delayInMillis: Long) {
    println("Routine $number starts work")
    delay(delayInMillis) // suspends or pauses the coroutine for the specified amount of time
    println("Routine $number has finished on ${Thread.currentThread().name}")
}