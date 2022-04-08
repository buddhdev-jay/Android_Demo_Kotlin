package com.example.android_demo_kotlin.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_data_binding.btn_login_data_binding


class DataBindingActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityDataBindingBinding
    val bindingViewModel: BindingViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        binding.viewModels = bindingViewModel
        binding.clickHandler = this
        binding.lifecycleOwner = this
        bindingViewModel.getLogInResult().observe(this) { result ->
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }
        binding.editTxtNumber.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                bindingViewModel.uppercase.value = binding.editTxtNumber.getUpdatedText()
                Log.e("Data", binding.editTxtNumber.getUpdatedText())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.btn_login_data_binding -> {
                bindingViewModel.performValidation()
            }
        }
    }
}