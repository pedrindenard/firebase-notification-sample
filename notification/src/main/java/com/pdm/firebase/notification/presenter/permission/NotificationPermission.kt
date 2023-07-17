package com.pdm.firebase.notification.presenter.permission

import android.Manifest
import android.app.Activity
import android.content.pm.PackageManager
import android.os.Build
import androidx.activity.result.ActivityResultCaller
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class NotificationPermission(
    private val context: Activity
) {

    private val caller = context as ActivityResultCaller

    private val requestPermissionLauncher = caller.registerForActivityResult(
        ActivityResultContracts.RequestPermission(),
    ) { isGranted: Boolean ->
        if (isGranted) {
            showDialog("Yes!", "FCM SDK (and your app) can post notifications.")
        } else {
            showDialog("Warning!", "Your app will not show notifications.")
        }
    }

    fun askNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {

            val per = ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS)

            if (per == PackageManager.PERMISSION_GRANTED) {
                showDialog("Hello!", "FCM SDK (and your app) can post notifications.")
            } else {
                requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
            }
        }
    }

    private fun showDialog(title: String, description: String, buttonTitle: String = "OK") {
        AlertDialog.Builder(context)
            .setTitle(title)
            .setMessage(description)
            .setPositiveButton(buttonTitle) { dialog, _ -> dialog.dismiss() }
            .create()
            .show()
    }
}