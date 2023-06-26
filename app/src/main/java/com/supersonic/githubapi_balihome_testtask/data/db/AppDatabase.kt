package com.supersonic.githubapi_balihome_testtask.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.supersonic.githubapi_balihome_testtask.data.model.Repository
import com.supersonic.githubapi_balihome_testtask.data.model.User

@Database(entities = [User::class, Repository::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
    abstract fun repositoryDao(): RepositoryDao
}