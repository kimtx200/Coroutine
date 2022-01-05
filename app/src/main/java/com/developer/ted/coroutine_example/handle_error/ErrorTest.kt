package com.developer.ted.coroutine_example.handle_error

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

object ErrorTest {
    suspend fun runNewScope() {
        coroutineScope {
            // Job 1
            coroutineScope {
                delay(2000)
                Log.d(MainActivity.TAG, "Job1] Throw Exception")
                throw Exception("Exception from Job1")
            }

            // Job 2
            coroutineScope {
                delay(1000)
                Log.d(MainActivity.TAG, "")
            }
        }
    }
}