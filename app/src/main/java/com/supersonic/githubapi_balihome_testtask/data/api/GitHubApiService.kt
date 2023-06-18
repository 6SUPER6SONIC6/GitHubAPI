package com.supersonic.githubapi_balihome_testtask.data.api

import com.supersonic.githubapi_balihome_testtask.data.model.UserData
import retrofit2.http.GET

interface GitHubApiService {

    @GET("users")
    suspend fun getUsers(): List<UserData>
}