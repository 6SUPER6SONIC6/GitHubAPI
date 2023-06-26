package com.supersonic.githubapi_balihome_testtask.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.supersonic.githubapi_balihome_testtask.data.model.Repository

@Dao
interface RepositoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRepositories(repositories: List<Repository>)

    @Query("SELECT * FROM repositories WHERE userLogin = :login")
    suspend fun getRepositoriesByLogin(login: String): List<Repository>
}