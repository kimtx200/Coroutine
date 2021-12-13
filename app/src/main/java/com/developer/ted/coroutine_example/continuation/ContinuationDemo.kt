package com.developer.ted.coroutine_example.continuation

import android.util.Log
import kotlinx.coroutines.*

@DelicateCoroutinesApi
object ContinuationDemo {
    private val TAG = "TED_TEST"

    fun run() {
        val job = GlobalScope.launch {
            repeat(2) { time ->
                runningLongTask(time, time + 5, time)
            }
        }

        runBlocking {
            job.join()
        }
    }

    private suspend fun runningLongTask(
        input1: Int,
        input2: Int,
        time: Int
    ) : Int {
        Log.d(TAG,"middle of task for 'time : $time'")
        delay(2000)
        val result = input1 + input2
        delay(2000)
        Log.d(TAG, "done task. result is $result")
        return result
    }
}