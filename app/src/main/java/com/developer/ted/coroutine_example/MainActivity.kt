package com.developer.ted.coroutine_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.developer.ted.coroutine_example.channel.GithubRepository
import com.developer.ted.coroutine_example.continuation.WithContextDemo
import com.developer.ted.coroutine_example.launch.LaunchDemo
import kotlinx.coroutines.DelicateCoroutinesApi

@OptIn(DelicateCoroutinesApi::class)
class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "TED_TEST"
    }

    private lateinit var repo: GithubRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // LaunchDemo.run()
        // ContinuationDemo.run()
        // WithContextDemo.runForSwitchingDispatcher()
        // AsyncDemo.run()
    }
}