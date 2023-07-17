package com.pdm.firebase.cloud.message

import android.app.Application
import com.pdm.firebase.notification.presenter.NotificationApplication

class NotificationApp : Application() {

    override fun onCreate() {
        super.onCreate()
        NotificationApplication.startFirebaseApplication(this)
    }
}