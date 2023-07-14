package com.pdm.firebase.cloud.message.presenter.adapter

import androidx.recyclerview.widget.DiffUtil
import com.pdm.firebase.cloud.message.data.entity.NotificationEntity

class NotificationDiffCallback : DiffUtil.ItemCallback<NotificationEntity>() {

    override fun areItemsTheSame(oldItem: NotificationEntity, newItem: NotificationEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: NotificationEntity, newItem: NotificationEntity): Boolean {
        return oldItem == newItem
    }
}