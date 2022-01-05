package com.developer.ted.coroutine_example.continuation

import android.util.Log
import com.developer.ted.coroutine_example.MainActivity
import kotlinx.coroutines.*

object WithContextDemo {
    fun runForException() {
        runBlocking {
            val job = launch {
                try {
                    repeat(1000) { time ->
                        Log.d(MainActivity.TAG, "I'm sleeping $time ...")
                        delay(500L)
                    }
                } finally {
                    // 이전에 실행중이던 코루틴 scope 는 exception 이 나는 순간 종료되게 됨
                    // 이 때, 해당 scope 에서 특정 루틴을 수행 할 수 있게끔 아래와 같이 withContext 를 사용 할 수 있음
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

    @OptIn(DelicateCoroutinesApi::class)
    fun runForSwitchingDispatcher() {
        GlobalScope.launch(Dispatchers.Default) {
            ensureActive() // 해당 job 이 active 한 상태인지를 체크한다. 아닐경우, CancellationException() 을 던짐

            Log.d(MainActivity.TAG, "IO Dispatcher is activated")
            delay(1000L)
            withContext(Dispatchers.Main) {
                Log.d(MainActivity.TAG, "Main Dispatcher is activated")
                updateUI()
            }
        }
    }

    private fun updateUI() {
        Log.d(MainActivity.TAG, "Update UI")
    }
}