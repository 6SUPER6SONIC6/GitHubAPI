package com.supersonic.githubapi_balihome_testtask.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.supersonic.githubapi_balihome_testtask.data.model.User

@Dao
interface UserDao {

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertUsers(users: List<User>)

@Query("SELECT * FROM users")
suspend fun getUsers(): List<User>

}