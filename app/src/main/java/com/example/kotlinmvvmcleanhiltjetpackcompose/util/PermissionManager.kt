package com.example.kotlinmvvmcleanhiltjetpackcompose.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.common.AppPermissionStatus

object PermissionManager {
    fun getStatus(context: Context, permission: String): AppPermissionStatus {
        return if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
            AppPermissionStatus.Granted
        } else {
            if (context is Activity && ActivityCompat.shouldShowRequestPermissionRationale(context, permission)) {
                AppPermissionStatus.Denied
            } else {
                AppPermissionStatus.PermanentlyDenied
            }
        }
    }

    fun openSettings(context: Context) {
        val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
            data = Uri.fromParts("package", context.packageName, null)
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        }
        context.startActivity(intent)
    }
}
