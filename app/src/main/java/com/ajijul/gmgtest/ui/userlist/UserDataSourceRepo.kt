package com.ajijul.gmgtest.ui.userlist

import android.util.Log
import androidx.paging.PageKeyedDataSource
import com.ajijul.gmgtest.db.UserDAO
import com.ajijul.gmgtest.helper.Utils
import com.ajijul.gmgtest.network.ResponseWrapper
import com.ajijul.gmgtest.network.UserAPIEndPoint
import com.ajijul.gmgtest.network.models.ResultX
import com.ajijul.gmgtest.network.models.UserBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class UserDataSourceRepo @Inject constructor(
    var apiEndPoint: UserAPIEndPoint,
    var dao: UserDAO
) :
    PageKeyedDataSource<String, ResultX>() {

    private val job = Job()
    private var coroutineIOScope: CoroutineScope? = CoroutineScope(Dispatchers.IO + job)
    override fun loadInitial(
        params: LoadInitialParams<String>,
        callback: LoadInitialCallback<String, ResultX>
    ) {
        fetchData("1", params.requestedLoadSize.toString()) {
            callback.onResult(it, null, "2")
        }

    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, ResultX>) {
        val page = params.key
        fetchData(page, params.requestedLoadSize.toString()) {
            callback.onResult(it, (page.toInt() + 1).toString())
        }

    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, ResultX>
    ) {
        val page = params.key
        fetchData(page, params.requestedLoadSize.toString()) {
            callback.onResult(it, (page.toInt() - 1).toString())
        }

    }

    private fun fetchData(page: String, pageSize: String, callback: (List<ResultX>) -> Unit) {
        coroutineIOScope?.launch {

            val result = Utils.safeApiCall {
                apiEndPoint.getArticles(page, pageSize)
            }
            when (result) {
                is ResponseWrapper.Success -> {
                    result.data?.body()?.results?.map { it ->
                        it.userImageUrlString =
                            it.picture?.large ?: it.picture?.medium ?: it.picture?.thumbnail ?: ""
                        it
                    }?.let {
                        callback(it)
                        dao.insertAllUsers(it)
                    }
                }
                is ResponseWrapper.Error -> {
                    callback(listOf())
                }
            }

        }
    }

    override fun invalidate() {
        super.invalidate()
        job.cancel()
    }
}