package com.supersonic.githubapi_balihome_testtask.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "repositories")
data class Repository(
   @PrimaryKey @SerializedName("id"                          ) var id                       : Int? = null ,
   @ColumnInfo(name = "name") @SerializedName("name"                        ) var name                     : String? = null,
   @ColumnInfo(name = "private") @SerializedName("private"                     ) var private                  : Boolean? = null,
   @ColumnInfo(name = "description") @SerializedName("description"                 ) var description              : String? = null,
   @ColumnInfo(name = "created_at") @SerializedName("created_at"                  ) var createdAt                : String? = null,
   @ColumnInfo(name = "language") @SerializedName("language"                    ) var language                 : String? = null,
   @ColumnInfo(name = "userLogin") var userLogin                 : String? = null,

)
