package com.pdm.firebase.notification.presenter

import android.app.Application
import com.google.firebase.FirebaseApp

object NotificationApplication {

    fun startFirebaseApplication(applicationContext: Application) {
        FirebaseApp.initializeApp(applicationContext)
    }

}