package com.ajijul.gmgtest.ui.userlist

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ajijul.gmgtest.base.BaseRepository
import com.ajijul.gmgtest.db.UserDAO
import com.ajijul.gmgtest.network.ResponseWrapper
import com.ajijul.gmgtest.network.UserAPIEndPoint
import com.ajijul.gmgtest.network.models.ResultX
import com.ajijul.gmgtest.network.models.UserBase
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    var repo: UserDataSourceRepo,
    var pageListConfig: PagedList.Config,
    var dao: UserDAO
) {


    fun observeLocalPagedSets(): LiveData<PagedList<ResultX>> {
        val dataSourceFactory = dao.getAllUsers()

        return LivePagedListBuilder(
            dataSourceFactory,
            pageListConfig
        ).build()
    }

    fun observeRemotePagedSets()
            : LiveData<PagedList<ResultX>> {

        return initializedPagedListBuilder(pageListConfig).build()
    }

    fun getProgressStatus()
            : LiveData<Boolean> {

        return repo.getLoadingStatus()
    }

    private val dataSourceFactory = object : DataSource.Factory<String, ResultX>() {
        override fun create(): DataSource<String, ResultX> {
            return repo
        }
    }

    private fun initializedPagedListBuilder(config: PagedList.Config):
            LivePagedListBuilder<String, ResultX> {
        return LivePagedListBuilder<String, ResultX>(dataSourceFactory, config)
    }
}