package com.pdm.firebase.notification.presenter.adapter

import androidx.recyclerview.widget.RecyclerView
import com.pdm.firebase.notification.data.entity.NotificationEntity
import com.pdm.firebase.notification.databinding.ItemNotificationBinding
import com.pdm.firebase.notification.presenter.delegate.NotificationClickListener

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