package com.pdm.firebase.cloud.message.presenter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.messaging.FirebaseMessaging
import com.pdm.firebase.cloud.message.data.NotificationDatabase
import com.pdm.firebase.cloud.message.databinding.ActivityNotificationBinding
import com.pdm.firebase.cloud.message.presenter.adapter.NotificationAdapter
import com.pdm.firebase.cloud.message.presenter.delegate.NotificationClickListener
import com.pdm.firebase.cloud.message.presenter.permission.NotificationPermission
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NotificationActivity : AppCompatActivity() {

    private val binding by lazy { ActivityNotificationBinding.inflate(layoutInflater) }
    private val permission by lazy { NotificationPermission(this) }
    private val database by lazy { NotificationDatabase(this) }
    private val adapter by lazy { NotificationAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupNotificationClickListener()
        setupNotificationAdapter()

        getNotifications()
        getFirebaseToken()

        permission.askNotificationPermission()
    }

    private fun setupNotificationAdapter() {
        binding.notificationsRecyclerView.adapter = adapter
        binding.notificationsRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getNotifications() = CoroutineScope(Dispatchers.IO).launch {
        database.notificationDao().getAllNotifications().collect { result ->
            withContext(Dispatchers.Main) {
                adapter.submitList(result)
            }
        }
    }

    private fun setupNotificationClickListener() {
        binding.notificationsClearAll.setOnClickListener {
            deleteAllNotifications()
        }

        adapter.setOnNotificationClickListener(object : NotificationClickListener {
            override fun onNotificationClick(id: Int) {
                deleteNotification(id)
            }
        })
    }

    private fun deleteNotification(id: Int) = CoroutineScope(Dispatchers.IO).launch {
        database.notificationDao().deleteNotification(id)
    }

    private fun deleteAllNotifications() = CoroutineScope(Dispatchers.IO).launch {
        database.notificationDao().deleteAllNotifications()
    }

    private fun getFirebaseToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                Log.d("FCM_TOKEN", "onCreate: ${task.result}")
            }
        }
    }
}