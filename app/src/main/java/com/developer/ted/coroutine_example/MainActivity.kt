package com.developer.ted.coroutine_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developer.ted.coroutine_example.continuation.ContinuationDemo
import com.developer.ted.coroutine_example.continuation.WithContextDemo
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

@OptIn(DelicateCoroutinesApi::class)
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "TED_TEST"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Launch.run()
        // ContinuationDemo.run()
        WithContextDemo.run()
    }
}