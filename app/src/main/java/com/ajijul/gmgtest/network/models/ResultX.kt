package com.ajijul.gmgtest.network.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class ResultX(
    val cell: String="",
    val dob: Dob? = null,
    val email: String = "",
    val gender: String = "",
    val id: Id?=null,
    val location: Location?=null,
    val login: Login?=null,
    val name: Name?=null,
    val nat: String="",
    val phone: String="",
    val picture: Picture?=null,
    val registered: Registered?=null
){
    @PrimaryKey(autoGenerate = true)
    var did : Int? = null


    var userImageUrlString : String = ""
}