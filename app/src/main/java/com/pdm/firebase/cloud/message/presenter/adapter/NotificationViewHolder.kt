package com.pdm.firebase.cloud.message.presenter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pdm.firebase.cloud.message.data.entity.NotificationEntity
import com.pdm.firebase.cloud.message.databinding.ItemNotificationBinding
import com.pdm.firebase.cloud.message.presenter.delegate.NotificationClickListener

class NotificationViewHolder(
    private val binding: ItemNotificationBinding
) : RecyclerView.ViewHolder(binding.root) {

    lateinit var notificationClickListener: NotificationClickListener

    fun bind(notification: NotificationEntity) {
        binding.itemNotificationTitle.text = notification.title
        binding.itemNotificationDescription.text = notification.description
        binding.itemNotificationImage

        binding.root.setOnClickListener {
            notificationClickListener.onNotificationClick(notification.id)
        }
    }
}