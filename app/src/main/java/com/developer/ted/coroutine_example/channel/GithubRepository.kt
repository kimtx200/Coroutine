package com.developer.ted.coroutine_example.channel

import com.developer.ted.coroutine_example.common.ApiManager
import com.developer.ted.coroutine_example.common.model.Repo
import com.developer.ted.coroutine_example.common.model.RequestData
import kotlinx.coroutines.runBlocking
import retrofit2.Call

class GithubRepository constructor(val requestData: RequestData) {
    private val api: GithubService by lazy {
        ApiManager.createService(
            requestData,
            GithubService::class.java
        )
    }

    suspend fun getOrgRepos(): List<Repo> = api.getOrgRepos("", 100)
}