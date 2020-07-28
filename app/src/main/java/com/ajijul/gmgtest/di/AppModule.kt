package com.ajijul.gmgtest.di

import android.content.Context
import android.content.Intent
import androidx.room.Room
import com.ajijul.gmgtest.db.UserDAO
import com.ajijul.gmgtest.db.UserDatabase
import com.ajijul.gmgtest.helper.Constant.DATABASE_NAME
import com.ajijul.gmgtest.network.UserAPIEndPoint
import com.ajijul.gmgtest.ui.userlist.UserRepository
import com.ajijul.gmgtest.ui.userlist.UserRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()// if I change the database version, old version will
            // remove from device and a new version will create.
            .build()


    @Singleton
    @Provides
    fun provideUserDao(db: UserDatabase) = db.getUserDao()



}