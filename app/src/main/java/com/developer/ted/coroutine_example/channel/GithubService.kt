package com.developer.ted.coroutine_example.channel

import com.developer.ted.coroutine_example.common.model.Repo
import com.developer.ted.coroutine_example.common.model.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("orgs/{org}/repos")
    suspend fun getOrgRepos(
        @Path("org") org: String,
        @Query("per_page") per_page: Int
    ): List<Repo>

    @GET("repos/{owner}/{repo}contributors")
    suspend fun getRepoContributors(
        @Path("owner") owner: String,
        @Path("repo") repo: String,
        @Query("per_page") per_page: Int
    ): List<User>
}