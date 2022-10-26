package com.lukaslechner.coroutineusecasesonandroid.playground.fundamentals

import kotlin.concurrent.thread

/**
 * Created by sajon on 10/26/22
 * Copyright (c) 2022 syftet ltd. All rights reserved.
 * sajon@syftet.com
 * Last modified $file.lastModified
 */

fun main() {
    /**
     * As we know that the coroutines are lightweight so we can
     * run more coroutine within a single thread
     */
    repeat(1_000_000) {
        thread {
            Thread.sleep(5000)
            print(".")
        }
    }
}