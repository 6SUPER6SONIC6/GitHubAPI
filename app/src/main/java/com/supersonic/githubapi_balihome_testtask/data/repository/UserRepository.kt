package com.supersonic.githubapi_balihome_testtask.data.repository

import com.supersonic.githubapi_balihome_testtask.data.api.GitHubApiService
import com.supersonic.githubapi_balihome_testtask.data.model.UserData

interface UserRepository {
    suspend fun getUsers(): List<UserData>
}
