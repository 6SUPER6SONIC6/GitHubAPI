package com.supersonic.githubapi_balihome_testtask.data.repository

import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUserRepositories(login: String): List<Repository>
}
