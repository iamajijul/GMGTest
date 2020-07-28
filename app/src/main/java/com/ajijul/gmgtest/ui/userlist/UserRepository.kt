package com.ajijul.gmgtest.ui.userlist

import androidx.lifecycle.LiveData
import com.ajijul.gmgtest.network.ResponseWrapper
import com.ajijul.gmgtest.network.models.ResultX
import com.ajijul.gmgtest.network.models.UserBase

interface UserRepository {

    suspend fun getArticles(): ResponseWrapper<UserBase?>
    suspend fun insertArticlesIntoDataBase(data: List<ResultX>)
    fun getAllArticlesFromDataBase(): LiveData<List<ResultX>>


}