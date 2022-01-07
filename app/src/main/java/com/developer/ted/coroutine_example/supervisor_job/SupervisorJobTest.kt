package com.developer.ted.coroutine_example.supervisor_job

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object SupervisorJobTest {

    suspend fun exceptionExample() {
        // Job1
        coroutineScope {
            // Job1-1
            launch {
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
}