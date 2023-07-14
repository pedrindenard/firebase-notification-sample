package com.pdm.firebase.cloud.message.domain.message

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.pdm.firebase.cloud.message.data.NotificationDatabase
import com.pdm.firebase.cloud.message.data.entity.NotificationEntity
import com.pdm.firebase.cloud.message.domain.NotificationChannel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MessageNotificationService : FirebaseMessagingService() {

    private val database by lazy { NotificationDatabase.invoke(this) }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.d("FCM_TOKEN", "onNewToken: $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val title = message.data["title"] ?: message.notification?.title ?: ""
        val description = message.data["body"] ?: message.notification?.body ?: ""
        val imageUrl = message.data["imageUrl"] ?: message.notification?.imageUrl ?: ""

        Log.d("FCM_TOKEN", "onMessageReceived: \n $title \n $description")

        val notificationManager = MessageNotificationImpl(this)
        val notificationChannel = NotificationChannel(notificationManager.notificationManager)

        notificationChannel.injectMessageChannelNotification()
        notificationManager.createNotification(title, description)

        insertNotification(title, description, imageUrl.toString())
    }

    private fun insertNotification(
        title: String, description: String, imageUrl: String
    ) = CoroutineScope(Dispatchers.IO).launch {

        val id = System.currentTimeMillis().toInt()

        database.notificationDao().insertNotification(
            NotificationEntity(
                id = id,
                title = title,
                description = description,
                imageUrl = imageUrl
            )
        )
    }
}