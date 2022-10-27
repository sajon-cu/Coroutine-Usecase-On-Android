package com.lukaslechner.coroutineusecasesonandroid.playground.coroutinebuilders

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by sajon on 10/27/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

fun main() = runBlocking<Unit> {
//    launch {
//        delay(500)
//        println("Printed within from coroutine")
//    }
    /**
     * launch {} coroutine builder returns a job object
     * which is basically a reference or representation of the thing that
     * they started with launch. A coroutine can be on of several states that
     * can use the job instance to take the state the coroutine is
     * currently in. Job can also be used to cancel the coroutine by call job.cancel()
     */
    val job = launch {
        networkRequest()
        println("result received")
    }

    job.join()
    println("end of runBlocking")
}

suspend fun networkRequest(): String {
    delay(500)
    return "Result"
}