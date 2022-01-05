package com.developer.ted.coroutine_example.supervisor_job

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.*

object SupervisorJobTest {

    suspend fun exceptionExample() {
        // Job1
        coroutineScope {
            // Job1-1
            launch(SupervisorJob()) {
                delay(1000)
                throw Exception("[Job1-1] cause runtime exception here :(")
            }

            // Job1-2
            launch {
                delay(2000)
                Log.d(MainActivity.TAG, "[Job1-2] executed")
            }
            // Job1-3
            launch {
                delay(500)
                Log.d(MainActivity.TAG, "[Job1-3] executed")
            }
        }

        // Job2
        coroutineScope {
            delay(1500)
            Log.d(MainActivity.TAG, "[Job2] executed")
        }
    }

    private suspend fun job1_1(): Int = coroutineScope {
        runCatching {
            delay(1000)
            val random = 2 // (1..3).random()
            if (random == 2) {
                throw Exception("[Job1-1] cause runtime exception here :(")
            } else {
                random
            }
        }.getOrElse {
            Log.e(MainActivity.TAG, it.message.toString())
        }
    }
}