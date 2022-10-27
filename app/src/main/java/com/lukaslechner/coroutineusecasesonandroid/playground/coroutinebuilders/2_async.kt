package com.lukaslechner.coroutineusecasesonandroid.playground.coroutinebuilders

import kotlinx.coroutines.*

/**
 * Created by sajon on 10/27/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */
fun main() = runBlocking<Unit> {
    val startTime = System.currentTimeMillis()

    /* val resultList = arrayListOf<String>()

    val job1 = launch {
        val result1 = networkCall(1)
        resultList.add(result1)
        println("result received $result1 after ${elapseMillis(startTime)}")
    }

    val job2 = launch {
        val result2 = networkCall(2)
        resultList.add(result2)
        println("result received $result2 after ${elapseMillis(startTime)}")
    }

    joinAll(job1, job2)
    */

    val deferred1 = async {
        val result1 = networkCall(1)
        println("result received $result1 after ${elapseMillis(startTime)}")
        result1
    }
    val deferred2 = async {
        val result2 = networkCall(2)
        println("result received $result2 after ${elapseMillis(startTime)}")
        result2
    }

    val resultList = listOf(deferred1.await(), deferred2.await())
    println("Result List: $resultList after ${elapseMillis(startTime)}")
}

suspend fun networkCall(number: Int): String {
    delay(500)
    return "result $number"
}

fun elapseMillis(startTime: Long) = System.currentTimeMillis() - startTime