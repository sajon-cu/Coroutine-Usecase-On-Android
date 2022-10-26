package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

/**
 * Created by sajon on 10/26/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

fun main() {
    println("main starts")
    routine(1, 500)
    routine(2, 300)
    println("main ends")
}

fun routine(number: Int, delay: Long) {
    println("Routine $number starts work")
    Thread.sleep(delay)
    println("Routine $number has finished")
}