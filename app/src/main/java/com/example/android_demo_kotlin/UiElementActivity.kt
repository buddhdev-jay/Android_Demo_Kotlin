package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.example.android_demo_kotlin.utils.ZERO
import kotlinx.android.synthetic.main.activity_uielement.btn_submit
import kotlinx.android.synthetic.main.activity_uielement.editxt_email
import kotlinx.android.synthetic.main.activity_uielement.editxt_name
import kotlinx.android.synthetic.main.toast_layout.view.tvMessage

class UiElementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_uielement)
        btn_submit.setOnClickListener {
            when {
                TextUtils.isEmpty(editxt_name.text) -> {
                    Toast.makeText(this, R.string.enter_name_toast, Toast.LENGTH_SHORT).show()
                }
                TextUtils.isEmpty(editxt_email.text) -> {
                    Toast.makeText(this, R.string.enter_email_toast, Toast.LENGTH_SHORT).show()
                }
                else -> {
                    showToast(getString(R.string.done))
                }
            }
        }
    }

    private fun showToast(message: String) {
        val toast = Toast(this)
        val view: View = LayoutInflater.from(this).inflate(R.layout.toast_layout, null)
        view.tvMessage.text = message
        toast.setGravity(Gravity.TOP, ZERO, ZERO)
        toast.view = view
        toast.show()
    }

}