package com.example.android_demo_kotlin

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.android_demo_kotlin.differentLayout.LayoutActivity
import kotlinx.android.synthetic.main.activity_main.btn_expandable_listview
import kotlinx.android.synthetic.main.activity_main.btn_expandable_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_fragments
import kotlinx.android.synthetic.main.activity_main.btn_intent
import kotlinx.android.synthetic.main.activity_main.btn_kotlin_basic
import kotlinx.android.synthetic.main.activity_main.btn_layouts
import kotlinx.android.synthetic.main.activity_main.btn_listview
import kotlinx.android.synthetic.main.activity_main.btn_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_recyclerview_grid
import kotlinx.android.synthetic.main.activity_main.btn_ui_element
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_one
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_two

class MainActivity : AppCompatActivity() {
    private val TAG = getString(R.string.mainactivity_log_tag)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "Oncreate Called")
        btn_kotlin_basic.setOnClickListener {
            intent = Intent(applicationContext, Kotlin_Basic::class.java)
            startActivity(intent)
        }
        btn_ui_element.setOnClickListener {
            intent = Intent(applicationContext, UiElementActivity::class.java)
            startActivity(intent)
        }
        btn_layouts.setOnClickListener {
            intent = Intent(applicationContext, LayoutActivity::class.java)
            intent.putExtra(getString(R.string.name_key_intent), "Jay")
            startActivity(intent)
        }
        btn_listview.setOnClickListener {
            intent = Intent(applicationContext, ListviewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview.setOnClickListener {
            intent = Intent(applicationContext, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview_grid.setOnClickListener {
            intent = Intent(applicationContext, GridLayoutRecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_one.setOnClickListener {
            intent = Intent(applicationContext, ViewPageroneActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_two.setOnClickListener {
            intent = Intent(applicationContext, ViewPagertwoActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_recyclerview.setOnClickListener {
            intent = Intent(applicationContext, ViewpagertwoRecyclerviewActivity::class.java)
            startActivity(intent)
        }
        btn_expandable_recyclerview.setOnClickListener {
            intent = Intent(applicationContext, ExpandableRecyclerviewActivity::class.java)
            startActivity(intent)
        }
        btn_expandable_listview.setOnClickListener {
            intent = Intent(applicationContext, ExpandableListviewActivity::class.java)
            startActivity(intent)
        }
        btn_fragments.setOnClickListener {
            intent = Intent(applicationContext,FragmentActivity::class.java)
            startActivity(intent)
        }
        btn_intent.setOnClickListener {
            intent = Intent(applicationContext, IntentActivity::class.java)
            resultLauncher.launch(intent)
        }
    }
    var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, result.data?.getStringExtra(getString(R.string.txt_data_name)), Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "OnStart Called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "OnResume Called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "OnPause Called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "OnStop Called")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "OnRestart Called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "OnDestroy Called")
    }
}