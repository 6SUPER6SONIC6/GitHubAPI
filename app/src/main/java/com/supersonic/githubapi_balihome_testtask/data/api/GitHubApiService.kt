package com.supersonic.githubapi_balihome_testtask.data.api

import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.model.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubApiService {

    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("users/{login}/repos")
    suspend fun getUserRepositories(@Path("login") login: String) : List<Repository>
}