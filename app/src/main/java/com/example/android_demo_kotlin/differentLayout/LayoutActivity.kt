package com.example.android_demo_kotlin.differentLayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.model.People
import kotlinx.android.synthetic.main.activity_layout.btn_constraint
import kotlinx.android.synthetic.main.activity_layout.btn_framelayout
import kotlinx.android.synthetic.main.activity_layout.btn_gridlayout
import kotlinx.android.synthetic.main.activity_layout.btn_includelayout
import kotlinx.android.synthetic.main.activity_layout.btn_linear_layout
import kotlinx.android.synthetic.main.activity_layout.btn_relative_layout

class LayoutActivity : AppCompatActivity() {
    lateinit var TAG :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)
        val name = intent.getStringExtra(getString(R.string.name_key_intent))
        Toast.makeText(this,name,Toast.LENGTH_SHORT).show()
        TAG  = getString(com.example.android_demo_kotlin.R.string.activity_log_tag)
        btn_linear_layout.setOnClickListener {
            intent = Intent(applicationContext,LinearLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_relative_layout.setOnClickListener {
            intent = Intent(applicationContext,RelativeLayoutActivity::class.java)
            val people : People = People("abc",true,R.drawable.img_avtar)
            intent.putExtra(getString(R.string.people_data_key_name),people)
            startActivity(intent)
        }
        btn_constraint.setOnClickListener {
            intent = Intent(applicationContext,ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_framelayout.setOnClickListener {
            intent = Intent(applicationContext,FrameLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_gridlayout.setOnClickListener {
            intent = Intent(applicationContext,GridLayoutActivity::class.java)
            startActivity(intent)
        }
        btn_includelayout.setOnClickListener {
            intent = Intent(applicationContext,IncludeandMergeActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG,"OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG,"OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG,"OnStop Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG,"OnRestart Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG,"OnDestroy Called")
    }
}