package com.developer.ted.coroutine_example.common

import com.developer.ted.coroutine_example.common.model.RequestData
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object ApiManager {
    private val BASE_URL = "https://api.github.com"

    fun <T> createService(
        requestData: RequestData,
        cls: Class<T>
    ): T = getRetrofit(requestData).create(cls)

    private fun getRetrofit(requestData: RequestData): Retrofit {
        val authToken = "Basic " + Base64.getEncoder()
            .encode("${requestData.username}:${requestData.password}".toByteArray())
            .toString(Charsets.UTF_8)

        val httpClient = OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val builder = original.newBuilder()
                    .header("Accept", "application/vnd.github.v3+json")
                    .header("Authorization", authToken)
                val request = builder.build()
                chain.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
    }
}