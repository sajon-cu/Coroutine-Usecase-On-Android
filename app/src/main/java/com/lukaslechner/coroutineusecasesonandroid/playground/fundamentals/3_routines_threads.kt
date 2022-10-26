package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlin.concurrent.thread

/**
 * Created by sajon on 10/26/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

fun main() {
    println("main starts")
    threadRoutine(1, 500)
    threadRoutine(2, 300)
    Thread.sleep(1000)
    println("main ends")
}

fun threadRoutine(number: Int, delay: Long) {
    thread {
        println("Routine $number starts work")
        Thread.sleep(delay)
        println("Routine $number has finished")
    }
}