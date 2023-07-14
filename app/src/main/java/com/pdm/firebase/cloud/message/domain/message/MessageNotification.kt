package com.pdm.firebase.cloud.message.domain.message

import android.app.NotificationManager

interface MessageNotification {

    val notificationManager: NotificationManager

    fun createNotification(title: String, description: String)

    fun dismissNotifications()

}