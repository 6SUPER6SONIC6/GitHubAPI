package com.supersonic.githubapi_balihome_testtask.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object {
        private const val BASE_URL = "https://api.github.com/"


        private val retrofit: Retrofit by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api: GitHubApiService by lazy {
            retrofit.create(GitHubApiService::class.java)
        }
    }

//    fun getService(): GitHubApiService {
//        retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
//
//        return retrofit.create(GitHubApiService::class.java)
//    }
}