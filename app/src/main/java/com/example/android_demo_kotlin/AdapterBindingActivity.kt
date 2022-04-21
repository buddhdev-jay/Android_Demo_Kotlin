package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.android_demo_kotlin.databinding.ActivityAdapterBindingBinding
import com.example.android_demo_kotlin.mvvm.data.Owner

class AdapterBindingActivity : AppCompatActivity() {
    lateinit var binding: ActivityAdapterBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_adapter_binding)
        val owner = Owner(getString(R.string.adapter_binding_url))
        binding.owner = owner
    }
}