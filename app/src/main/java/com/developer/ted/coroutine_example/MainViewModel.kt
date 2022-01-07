package com.developer.ted.coroutine_example

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.ted.coroutine_example.supervisor_job.SupervisorJobTest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val exceptionHandler by lazy {
        CoroutineExceptionHandler { _, throwable -> handleException(throwable) }
    }

    fun run() {
        viewModelScope.launch(exceptionHandler) { // combined coroutine context
            // LaunchDemo.run()
            // ContinuationDemo.run()
            // WithContextDemo.runForSwitchingDispatcher()
            // AsyncDemo.run()
            // CancellationDemo.cancelAsync()
            SupervisorJobTest.exceptionExample()
        }
    }

    private fun handleException(e: Throwable) {
        Log.e(MainActivity.TAG, e.message.toString())
    }
}