package com.ajijul.gmgtest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import fr.dasilvacampos.network.monitoring.ConnectivityStateHolder.registerConnectivityBroadcaster
import timber.log.Timber

@HiltAndroidApp
class Application : Application() {

    override fun onCreate() {
        super.onCreate()
        registerConnectivityBroadcaster()
        Timber.plant(Timber.DebugTree())
    }
}