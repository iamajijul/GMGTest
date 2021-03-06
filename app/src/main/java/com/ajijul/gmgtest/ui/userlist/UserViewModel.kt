package com.ajijul.gmgtest.ui.userlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.ajijul.gmgtest.base.BaseRepository
import com.ajijul.gmgtest.base.BaseViewModel
import com.ajijul.gmgtest.network.ResponseWrapper
import com.ajijul.gmgtest.network.models.ResultX
import com.ajijul.gmgtest.network.models.UserBase
import kotlinx.coroutines.Dispatchers

class UserViewModel @ViewModelInject constructor(private var repository: UserRepositoryImpl) :
    BaseViewModel() {


    private var offlineDataWatcher : LiveData<PagedList<ResultX>> = repository.observeLocalPagedSets()
    private var onlineDataWatcher : LiveData<PagedList<ResultX>> = repository.observeRemotePagedSets()
    var selectedUser = MutableLiveData<ResultX>()

    fun observeUsersOffline(): LiveData<PagedList<ResultX>> = offlineDataWatcher
    fun observeUsersOnline(): LiveData<PagedList<ResultX>> = onlineDataWatcher
    fun observeLoadingStatus(): LiveData<Boolean> = repository.getLoadingStatus()


    fun setSelectedUser(user: ResultX) {
        selectedUser.value = user
    }
}

