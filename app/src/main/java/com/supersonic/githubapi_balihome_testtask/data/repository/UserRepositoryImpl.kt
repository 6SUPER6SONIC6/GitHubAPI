package com.supersonic.githubapi_balihome_testtask.data.repository

import com.supersonic.githubapi_balihome_testtask.data.api.GitHubApiService
import com.supersonic.githubapi_balihome_testtask.data.model.UserData

class UserRepositoryImpl(private val apiService: GitHubApiService) : UserRepository {
    override suspend fun getUsers(): List<UserData> {
        return apiService.getUsers()
    }
}