package com.supersonic.githubapi_balihome_testtask.data.repository

import com.supersonic.githubapi_balihome_testtask.data.api.GitHubApiService
import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.model.User

class UserRepositoryImpl(private val apiService: GitHubApiService) : UserRepository {
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }

    override suspend fun getUserRepositories(login: String): List<Repository> {
        return apiService.getUserRepositories(login)
    }
}