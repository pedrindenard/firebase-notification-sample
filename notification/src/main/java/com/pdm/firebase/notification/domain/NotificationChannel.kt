package com.pdm.firebase.notification.domain

import android.app.NotificationChannel
import android.app.NotificationChannelGroup
import android.app.NotificationManager

class NotificationChannel(
    private val manager: NotificationManager
) {

    fun injectMessageChannelNotification() {
        val channelGroup = NotificationChannelGroup(
            NotificationConfig.MSG_GROUP_ID,
            NotificationConfig.MSG_GROUP_NAME
        )

        val channel = NotificationChannel(
            NotificationConfig.MSG_CHANNEL_ID,
            NotificationConfig.MSG_CHANNEL_NAME,
            NotificationManager.IMPORTANCE_DEFAULT
        )

        channel.importance = NotificationManager.IMPORTANCE_DEFAULT
        channel.vibrationPattern = longArrayOf(NotificationConfig.VIBRATION)

        channel.enableVibration(true)
        channel.enableLights(true)

        manager.createNotificationChannelGroup(channelGroup)
        manager.createNotificationChannel(channel)
    }

}