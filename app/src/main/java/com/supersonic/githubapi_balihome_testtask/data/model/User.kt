package com.supersonic.githubapi_balihome_testtask.data.model

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login"               ) var login             : String ,
    @SerializedName("id"                  ) var id                : Int,
    @SerializedName("avatar_url"          ) var avatarUrl         : String,
)
