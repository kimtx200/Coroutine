package com.developer.ted.coroutine_example.cancellation

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.*

object CancellationDemo {

    fun cancelLaunch() {
        runBlocking {
            val job = launch(Dispatchers.Default) {
                try {
                    sayHello()
                } catch (e: CancellationException) {
                    Log.d(MainActivity.TAG, "request canceled!")
                } finally {
                    withContext(NonCancellable) { doFinally() }
                }
            }

            delay(1000L)
            job.cancel()
            Log.d(MainActivity.TAG, "done ")
        }
    }

    fun cancelAsync() {
        runBlocking {
            val deffer = async {
                try {
                    sayHello()
                } catch (e: CancellationException) {
                    Log.d(MainActivity.TAG, "request canceled!")
                } finally {
                    withContext(NonCancellable) { doFinally() }
                }
            }

            delay(1000L)
            deffer.cancel()
            Log.d(MainActivity.TAG, "done ")
        }
    }

    private suspend fun sayHello() {
        val startTime = System.currentTimeMillis()
        coroutineScope {
            var nextPrintTime = startTime
            var i = 0
            while (i < 5) {
                // ensureActive()
                if (System.currentTimeMillis() >= nextPrintTime) {
                    Log.d(MainActivity.TAG, "Hello ${i++}")
                    nextPrintTime += 500L
                }
            }
        }
    }

    private suspend fun doFinally() {
        coroutineScope {
            delay(1000L)
            Log.d(MainActivity.TAG, "launch final coroutine after exception")
        }
    }
}