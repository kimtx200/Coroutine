package com.developer.ted.coroutine_example.launch

import android.util.Log
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

object Launch {
    private val TAG = "TED_TEST"

    fun run() {
        // 1개의 parent job 안에 2개의 scope
        runBlocking {
            coroutineScope {
                val prefix1 = hello()
                val suffix1 = world()
                print(prefix1, suffix1)
            }

            coroutineScope {
                val prefix2 = eatRice()
                val suffix2 = eatSoup()
                print(prefix2, suffix2)
            }
        }
        Log.e(TAG, "--------------------")

        // 1개의 empty parent job 안에 2개의 children job
        runBlocking {
            launch {
                val prefix1 = hello()
                val suffix1 = world()
                print(prefix1, suffix1)
            }

            launch {
                val prefix2 = eatRice()
                val suffix2 = eatSoup()
                print(prefix2, suffix2)
            }
        }
        Log.e(TAG, "--------------------")

        // 1개의 parent job 과 다른 2개의 children job 이 섞여 있다면?
        runBlocking {
            coroutineScope {
                val prefix1 = hello()
                val suffix1 = world()
                print(prefix1, suffix1)
            }

            launch {
                val prefix1 = hello()
                val suffix1 = world()
                print(prefix1, suffix1)
            }

            coroutineScope {
                val prefix2 = eatRice()
                val suffix2 = eatSoup()
                print(prefix2, suffix2)
            }

            launch {
                val prefix2 = eatRice()
                val suffix2 = eatSoup()
                print(prefix2, suffix2)
            }
        }
    }

    private suspend fun hello(): String {
        Log.v(TAG, "start hello()")
        delay(300)
        Log.v(TAG, "end hello()")
        return "Hello!"
    }

    private suspend fun world(): String {
        Log.v(TAG, "start world()")
        delay(100)
        Log.v(TAG, "end world()")
        return "World :)"
    }

    private suspend fun eatRice(): String {
        Log.i(TAG, "start eating rice()")
        delay(150)
        Log.i(TAG, "end eating rice()")
        return "Eat Rice"
    }

    private suspend fun eatSoup(): String {
        Log.i(TAG, "start eating soup()")
        delay(100)
        Log.i(TAG, "end eating soup()")
        return "Eat Soup"
    }

    private suspend fun print(
        prefix: String,
        suffix: String
    ) {
        Log.w(TAG, "start print()")
        delay(10)
        Log.w(TAG, "$prefix $suffix")
        Log.w(TAG, "end print()")
    }
}