package com.example.android_demo_kotlin.MVP

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.core.widget.addTextChangedListener
import com.example.android_demo_kotlin.R
import kotlinx.android.synthetic.main.activity_mvpactivity.txt_email_mvp
import kotlinx.android.synthetic.main.activity_mvpactivity.txt_mvp
import kotlinx.android.synthetic.main.activity_mvpactivity.txt_name_mvp

class MVPActivity : AppCompatActivity() ,Presenter.View{

    lateinit var presenter:Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvpactivity)
        presenter = Presenter(this)

      txt_email_mvp.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                presenter.updateEmail(s.toString())
            }
        })
        txt_name_mvp.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                presenter.updateFullName(s.toString());
            }
        })
    }

    override fun updateUserInfoTextView(info: String?) {
        txt_mvp.text = info
    }


}