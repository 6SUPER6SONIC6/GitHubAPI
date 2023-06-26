package com.supersonic.githubapi_balihome_testtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(
    @PrimaryKey @SerializedName("id"                  ) var id                : Int? = null,
    @ColumnInfo(name = "login") @SerializedName("login"               ) var login             : String? = null ,
    @ColumnInfo(name = "avatar_url") @SerializedName("avatar_url"          ) var avatarUrl         : String? = null,
)
