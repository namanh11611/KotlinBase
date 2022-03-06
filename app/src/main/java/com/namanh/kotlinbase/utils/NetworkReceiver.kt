package com.namanh.kotlinbase.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.namanh.kotlinbase.R

class NetworkReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (NetworkUtils.isNetworkConnected(context)) {
            Toast.makeText(
                context,
                context?.getString(R.string.connection_ready),
                Toast.LENGTH_LONG
            ).show()
        }
    }
}