package com.example.android_demo_kotlin.databinding

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class BindingViewModel : ViewModel() {

    var intvalue = ""
    val name = MutableLiveData("abc")

    var email: String = ""
    var password: String = ""

    private val logInResult = MutableLiveData<String>()

    fun getLogInResult(): LiveData<String> = logInResult

    @BindingAdapter("android:text")
    fun EditText.integerValue(value: Int) {
        this.setText(value.toString())
    }

    @InverseBindingAdapter(attribute = "android:text")
    fun getstring(input: String): String {
        intvalue = input
        return intvalue
    }

    @BindingAdapter("emailValidator")
    fun emailValidator(editText: EditText, email: String?) {
        if (TextUtils.isEmpty(email)) {
            editText.error = "Please Enter Email"
            return
        }
    }

    fun performValidation() {
        if (email.isBlank()) {
            logInResult.value = "Invalid username"
            return
        }
        if (password.isBlank()) {
            logInResult.value = "Invalid password"
            return
        }
        logInResult.value = "Valid credentials :)"
    }

    @BindingAdapter(" android:hint")
    fun setHintMessage(view: EditText, Message: String) {
        view.hint = Message
    }

    @BindingAdapter("android:textAttrChanged")
    fun setTextChangedListener(editText: EditText, listener: InverseBindingListener) {
        editText.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                listener.onChange()
            }
        })
    }


}