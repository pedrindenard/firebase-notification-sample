package com.pdm.firebase.notification.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.pdm.firebase.notification.data.entity.NotificationEntity
import com.pdm.firebase.notification.databinding.ItemNotificationBinding
import com.pdm.firebase.notification.presenter.delegate.NotificationClickListener

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