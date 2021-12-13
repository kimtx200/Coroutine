package com.developer.ted.coroutine_example.continuation

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.*

object WithContextDemo {
    fun run() {
        runBlocking {
            val job = launch {
                try {
                    repeat(1000) { time ->
                        Log.d(MainActivity.TAG, "I'm sleeping $time ...")
                        delay(500L)
                    }
                } finally {
                    withContext(NonCancellable) {
                        delay(1000L)
                        Log.d(MainActivity.TAG, "I'm running finally!")
                    }
                }
            }

            Log.d(MainActivity.TAG, "I'm tired of waiting :(")
            delay(1300L)
            job.cancelAndJoin()
            Log.d(MainActivity.TAG, "Now i can quit ;)")
        }

    }
}