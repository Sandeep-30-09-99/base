package com.rk.base

import android.app.Application
import android.content.Intent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(){
    private var isRestarting: Boolean = false

    fun onLogout() {
        restartApp()
    }

    private fun restartApp() {
        if (!isRestarting) {
            isRestarting = true
            val intent =
                baseContext.packageManager.getLaunchIntentForPackage(baseContext.packageName)
            intent?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    override fun onCreate() {
        instance = this
        super.onCreate()
    }

    companion object {
        private var instance: App? = null
        fun getInstance(): App? {
            return instance
        }
    }

}
