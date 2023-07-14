package com.pdm.firebase.cloud.message.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.pdm.firebase.cloud.message.data.entity.NotificationEntity
import kotlinx.coroutines.flow.Flow

@Dao
internal interface NotificationDao {

    @Insert
    fun insertNotification(entity: NotificationEntity)

    @Query("SELECT * FROM notifications")
    fun getAllNotifications(): Flow<List<NotificationEntity>>

    @Query("DELETE FROM notifications")
    fun deleteAllNotifications()

    @Query("DELETE FROM notifications WHERE id = :id")
    fun deleteNotification(id: Int)

}