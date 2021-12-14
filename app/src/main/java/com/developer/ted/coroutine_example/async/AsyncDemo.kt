package com.developer.ted.coroutine_example.async

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.*

object AsyncDemo {
    fun run() {
        runBlocking {
            val deferreds: List<Deferred<Int>> = (1..3).map { time ->
                async {
                    delay(1000L / time)
                    Log.d(MainActivity.TAG, "[async] loading... : $time")
                    time
                }
            }

            val result = deferreds.awaitAll().sum()
            Log.d(MainActivity.TAG, "result : $result")
        }
    }
}