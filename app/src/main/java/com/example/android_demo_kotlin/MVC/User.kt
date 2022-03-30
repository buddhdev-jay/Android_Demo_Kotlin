
import android.text.TextUtils

import android.util.Patterns

import com.example.android_demo_kotlin.MVC.IUser


class User(private val email: String, private val password: String) : IUser {

    override fun getEmail(): String? {
        return email
    }

    override fun getPassword(): String? {
        return password
    }

    override fun isValid(): Int {
       if (TextUtils.isEmpty(getEmail())){
           return 0
       }else if (!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches()){
           return  1
       }else if(TextUtils.isEmpty(getPassword())){
           return 2
       }else return -1
    }
}