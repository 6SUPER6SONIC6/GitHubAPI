package com.supersonic.githubapi_balihome_testtask.data.model

import com.google.gson.annotations.SerializedName
data class Repository(
   @SerializedName("id"                          ) var id                       : Int?              = null,
   @SerializedName("name"                        ) var name                     : String?           = null,
   @SerializedName("full_name"                   ) var fullName                 : String?           = null,
   @SerializedName("private"                     ) var private                  : Boolean?          = null,
   @SerializedName("description"                 ) var description              : String?           = null,
   @SerializedName("created_at"                  ) var createdAt                : String?           = null,
   @SerializedName("updated_at"                  ) var updatedAt                : String?           = null,
   @SerializedName("pushed_at"                   ) var pushedAt                 : String?           = null,
   @SerializedName("size"                        ) var size                     : Int?              = null,
   @SerializedName("stargazers_count"            ) var stargazersCount          : Int?              = null,
   @SerializedName("watchers_count"              ) var watchersCount            : Int?              = null,
   @SerializedName("language"                    ) var language                 : String?           = null,
   @SerializedName("has_issues"                  ) var hasIssues                : Boolean?          = null,
   @SerializedName("has_projects"                ) var hasProjects              : Boolean?          = null,
   @SerializedName("has_downloads"               ) var hasDownloads             : Boolean?          = null,
   @SerializedName("has_wiki"                    ) var hasWiki                  : Boolean?          = null,
   @SerializedName("has_pages"                   ) var hasPages                 : Boolean?          = null,
   @SerializedName("has_discussions"             ) var hasDiscussions           : Boolean?          = null,
   @SerializedName("forks_count"                 ) var forksCount               : Int?              = null,

)
