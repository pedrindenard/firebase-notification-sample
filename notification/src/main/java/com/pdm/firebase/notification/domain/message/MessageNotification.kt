package com.pdm.firebase.notification.domain.message

import android.app.NotificationManager

interface MessageNotification {

    val notificationManager: NotificationManager

    fun createNotification(title: String, description: String)

    fun dismissNotifications()

}