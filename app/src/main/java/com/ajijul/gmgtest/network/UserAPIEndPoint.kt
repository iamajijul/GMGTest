package com.ajijul.gmgtest.network

import com.ajijul.gmgtest.network.models.UserBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface UserAPIEndPoint {

    @GET("api")
    suspend fun getArticles(
        @Query("page") page: String = "1",
        @Query("results") results: String = "10"
    ): Response<UserBase>
}

//https://randomuser.me/api/?page=1&results=10