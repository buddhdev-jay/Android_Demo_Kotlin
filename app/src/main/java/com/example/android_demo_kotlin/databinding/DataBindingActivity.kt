package com.example.android_demo_kotlin.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android_demo_kotlin.R


class DataBindingActivity : AppCompatActivity() {

    lateinit var binding: ActivityDataBindingBinding
    val bindingViewModel: BindingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        binding.viewModels = bindingViewModel
        binding.lifecycleOwner = this
        bindingViewModel.getLogInResult().observe(this, Observer { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        })

    }
}