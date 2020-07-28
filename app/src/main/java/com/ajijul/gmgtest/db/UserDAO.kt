package com.ajijul.gmgtest.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.ajijul.gmgtest.network.models.ResultX

@Dao
interface UserDAO {

    @Transaction
    suspend fun insertOrUpdateUsers(articles: List<ResultX>) {
        deleteAllUsers()
        insertAllUsers(articles)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUsers(articles: List<ResultX>)


    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table")
    fun getAllUsers(): DataSource.Factory<Int, ResultX>


}