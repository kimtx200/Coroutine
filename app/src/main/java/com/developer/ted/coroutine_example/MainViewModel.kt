package com.developer.ted.coroutine_example

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.developer.ted.coroutine_example.supervisor_job.SupervisorJobTest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        Log.e(MainActivity.TAG, throwable.message.toString())
    }

    fun test() {
        viewModelScope.launch(exceptionHandler + Dispatchers.Main) { // combined coroutine context
            // LaunchDemo.run()
            // ContinuationDemo.run()
            // WithContextDemo.runForSwitchingDispatcher()
            // AsyncDemo.run()
            // CancellationDemo.cancelAsync()
            SupervisorJobTest.exceptionExample()
        }
    }
}