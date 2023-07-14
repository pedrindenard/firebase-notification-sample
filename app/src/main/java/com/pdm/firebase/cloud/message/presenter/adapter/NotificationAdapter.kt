package com.pdm.firebase.cloud.message.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.pdm.firebase.cloud.message.data.entity.NotificationEntity
import com.pdm.firebase.cloud.message.databinding.ItemNotificationBinding
import com.pdm.firebase.cloud.message.presenter.delegate.NotificationClickListener

class NotificationAdapter : ListAdapter<NotificationEntity, NotificationViewHolder>(NotificationDiffCallback()) {

    private lateinit var notificationClickListener: NotificationClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
        return NotificationViewHolder(
            ItemNotificationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.notificationClickListener = notificationClickListener
        holder.bind(getItem(position))
    }

    fun setOnNotificationClickListener(listener: NotificationClickListener) {
        notificationClickListener = listener
    }
}