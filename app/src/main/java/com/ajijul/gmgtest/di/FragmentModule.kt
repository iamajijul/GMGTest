package com.ajijul.gmgtest.di

import androidx.paging.PagedList
import com.ajijul.gmgtest.db.UserDAO
import com.ajijul.gmgtest.network.UserAPIEndPoint
import com.ajijul.gmgtest.ui.userlist.UserDataSourceRepo
import com.ajijul.gmgtest.ui.userlist.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.FragmentComponent
import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext

@Module
@InstallIn(ActivityComponent::class)
object FragmentModule {
    @Provides
    fun provideUserDataSourceRepo(
        api: UserAPIEndPoint,
        dao: UserDAO) = UserDataSourceRepo(api, dao)


    @Provides
    fun provideUserListPageCong() = PagedList.Config.Builder()
        .setInitialLoadSizeHint(10)
        .setPageSize(10)
        .setEnablePlaceholders(false)
        .build()

    @Provides
    fun provideUserRepository(
        api: UserAPIEndPoint,
        pageConfig: PagedList.Config,
        dao: UserDAO
    ): UserRepositoryImpl =
        UserRepositoryImpl(api, pageListConfig = pageConfig, dao = dao)


}