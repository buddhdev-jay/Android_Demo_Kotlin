package com.example.android_demo_kotlin

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import com.example.android_demo_kotlin.utils.ZERO
import kotlinx.android.synthetic.main.activity_pending.btn_pending_intent_start

class PendingActivity : AppCompatActivity() {
    lateinit var notificationManager: NotificationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pending)
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        btn_pending_intent_start.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val pendingIntent = PendingIntent.getActivity(this, ZERO, intent, PendingIntent.FLAG_IMMUTABLE)
            val builder_new = NotificationCompat.Builder(this, getString(R.string.hello_nullsafe_string))
                .setSmallIcon(R.drawable.ic_baseline_account_box_24)
                .setContentTitle(getString(R.string.my_app_txt))
                .setContentText(getString(R.string.app_notification_txt))
                .addAction(R.drawable.img_avtar,getString(R.string.open_app_title),pendingIntent)
                .setContentIntent(pendingIntent)
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(getString(R.string.hello_nullsafe_string), getString(R.string.hello_nullsafe_string), NotificationManager.IMPORTANCE_HIGH)
                manager.createNotificationChannel(channel)
            }
            manager.notify(ZERO, builder_new.build())
        }
    }
}