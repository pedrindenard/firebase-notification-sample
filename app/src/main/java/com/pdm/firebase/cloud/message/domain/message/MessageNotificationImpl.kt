package com.pdm.firebase.cloud.message.domain.message

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.app.NotificationCompat
import com.pdm.firebase.cloud.message.domain.NotificationConfig

class MessageNotificationImpl(
    private val context: Context
) : MessageNotification {

    override val notificationManager: NotificationManager by lazy {
        context.getSystemService(NotificationManager::class.java) as NotificationManager
    }

    override fun createNotification(title: String, description: String) {
        notificationManager.notify(
            NotificationConfig.MSG_NOTIFICATION_ID, createMessage(title, description).build()
        )
    }

    override fun dismissNotifications() {
        notificationManager.cancelAll()
    }

    private fun createMessage(title: String, description: String): NotificationCompat.Builder {
        val builder = NotificationCompat.Builder(context, NotificationConfig.MSG_CHANNEL_ID)

        builder.setContentTitle(title)
        builder.setTicker(description)
        builder.setSmallIcon(android.R.drawable.ic_secure)

        builder.createPendingIntent()
        builder.createNotificationStyle(title, description)

        builder.setDefaults(Notification.DEFAULT_VIBRATE)
        builder.setChannelId(NotificationConfig.MSG_CHANNEL_ID)
        builder.setGroup(NotificationConfig.MSG_GROUP_ID)

        builder.priority = NotificationCompat.PRIORITY_DEFAULT

        builder.setAutoCancel(true)
        builder.setGroupSummary(true)

        return builder
    }

    private fun NotificationCompat.Builder.createPendingIntent() {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(NotificationConfig.DEEP_LINK))
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        val pendingIntent = PendingIntent.getActivity(context, 0, intent, NotificationConfig.FLAGS)
        setContentIntent(pendingIntent)
    }

    private fun NotificationCompat.Builder.createNotificationStyle(
        title: String,
        description: String
    ) {
        val style = NotificationCompat
            .BigTextStyle()
            .bigText(title)
            .bigText(description)

        setStyle(style)
    }
}