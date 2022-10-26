package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Created by sajon on 10/26/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

fun main() = runBlocking<Unit> {
    /**
     * As we know that the coroutines are lightweight so we can
     * run more coroutine within a single thread
     */
    repeat(1_000_000) {
        launch {
            delay(5000)
            print(".")
        }
    }
}