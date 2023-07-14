package com.pdm.firebase.cloud.message.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pdm.firebase.cloud.message.data.dao.NotificationDao
import com.pdm.firebase.cloud.message.data.entity.NotificationEntity

@Database(
    entities = [NotificationEntity::class],
    exportSchema = false,
    version = 1
)
internal abstract class NotificationDatabase : RoomDatabase() {

    abstract fun notificationDao(): NotificationDao

    companion object {

        @Volatile
        private var instance: NotificationDatabase? = null

        operator fun invoke(context: Context) = instance ?: synchronized(NotificationDatabase::class) {
            buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room
            .databaseBuilder(context, NotificationDatabase::class.java, "notification.db")
            .fallbackToDestructiveMigration()
            .build()
    }
}