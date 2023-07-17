package com.pdm.firebase.notification.domain

import android.app.PendingIntent

object NotificationConfig {

    const val FLAGS = PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT

    const val DEEP_LINK: String = "com.telefonica.aura.widget://deeplink/path"

    const val MSG_CHANNEL_NAME: String = "AURA CHANNEL MESSAGE"
    const val MSG_CHANNEL_ID: String = "AURA_MESSAGE_CHANNEL"

    const val MSG_GROUP_NAME: String = "AURA GROUP MESSAGE"
    const val MSG_GROUP_ID: String = "AURA_MESSAGE_GROUP"

    const val MSG_NOTIFICATION_ID = 684945

    const val VIBRATION: Long = 0

}