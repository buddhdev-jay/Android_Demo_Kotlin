package com.example.android_demo_kotlin.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.example.android_demo_kotlin.R


class DataBindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataBindingBinding
    val bindingViewModel: BindingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        binding.viewModels = bindingViewModel
        binding.lifecycleOwner = this


    }
}