package com.namanh.kotlinbase.view.main

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.namanh.kotlinbase.R
import com.namanh.kotlinbase.utils.NetworkReceiver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mNetworkReceiver: NetworkReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ignore system night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        // Registers BroadcastReceiver to track network connection changes.
        val intentFilter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        mNetworkReceiver = NetworkReceiver()
        this.registerReceiver(mNetworkReceiver, intentFilter)
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unregisters BroadcastReceiver when app is destroyed.
        this.unregisterReceiver(mNetworkReceiver)
    }
}