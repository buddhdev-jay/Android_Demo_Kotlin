package com.example.android_demo_kotlin

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver: BroadcastReceiver() {
    override fun onReceive(context: Context?, p1: Intent?) {
        Toast.makeText(context, context?.getString(R.string.receiver_txt), Toast.LENGTH_LONG).show();
    }
}