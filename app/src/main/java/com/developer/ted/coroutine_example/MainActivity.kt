package com.developer.ted.coroutine_example

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.developer.ted.coroutine_example.channel.GithubRepository
import com.developer.ted.coroutine_example.supervisor_job.SupervisorJobTest
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG = "TED_TEST"
    }

    private val viewModel: MainViewModel by viewModels()
    private lateinit var repo: GithubRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.test()
    }
}