package com.example.android_demo_kotlin

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intent.btn_back_intent
import kotlinx.android.synthetic.main.activity_intent.btn_implicit_intent
import kotlinx.android.synthetic.main.activity_intent.btn_pending_intent
import kotlinx.android.synthetic.main.activity_intent.editxt_namme_intent

class IntentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent)
        btn_implicit_intent.setOnClickListener {
            intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(getString(R.string.google_url))
            startActivity(intent)
        }
        btn_back_intent.setOnClickListener {
            intent.putExtra(getString(R.string.txt_data_name),editxt_namme_intent.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}