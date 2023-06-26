package com.supersonic.githubapi_balihome_testtask.data.repository

import com.supersonic.githubapi_balihome_testtask.data.api.GitHubApiService
import com.supersonic.githubapi_balihome_testtask.data.db.RepositoryDao
import com.supersonic.githubapi_balihome_testtask.data.db.UserDao
import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.model.User

class UserRepositoryImpl(
    private val apiService: GitHubApiService,
    private val userDao: UserDao,
    private val repositoryDao: RepositoryDao
    ) : UserRepository {

    override suspend fun getUsers(): List<User> {
        val usersFromDb = userDao.getUsers()

        return if (usersFromDb.isNotEmpty()){
            usersFromDb
        } else {
            val users = apiService.getUsers()
            userDao.insertUsers(users)
            users
        }

    }

    override suspend fun getUserRepositories(login: String): List<Repository> {
        val repositoriesFromDb = repositoryDao.getRepositoriesByLogin(login)

        return if (repositoriesFromDb.isNotEmpty()){
            repositoriesFromDb
        } else {
            val repositories = apiService.getUserRepositories(login)
            val userRepositories = repositories.map { repository ->
                Repository(repository.id, repository.name, repository.private, repository.description, repository.createdAt, repository.language, login)
            }
            repositoryDao.insertRepositories(userRepositories)
            repositories
        }
    }
}