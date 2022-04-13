package com.example.android_demo_kotlin

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.android_demo_kotlin.databinding.DataBindingActivity
import com.example.android_demo_kotlin.MVC.MVCActivity
import com.example.android_demo_kotlin.MVP.MVPActivity
import com.example.android_demo_kotlin.mvvm.MVVMActivity
import com.example.android_demo_kotlin.WebServices.RecyclerWebActivity
import com.example.android_demo_kotlin.databinding.TempActivity
import com.example.android_demo_kotlin.differentLayout.LayoutActivity
import kotlinx.android.synthetic.main.activity_main.btn_bottomnavigation
import kotlinx.android.synthetic.main.activity_main.btn_expandable_listview
import kotlinx.android.synthetic.main.activity_main.btn_expandable_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_fragments
import kotlinx.android.synthetic.main.activity_main.btn_intent
import kotlinx.android.synthetic.main.activity_main.btn_inversebinding
import kotlinx.android.synthetic.main.activity_main.btn_kotlin_basic
import kotlinx.android.synthetic.main.activity_main.btn_layouts
import kotlinx.android.synthetic.main.activity_main.btn_listview
import kotlinx.android.synthetic.main.activity_main.btn_mvc
import kotlinx.android.synthetic.main.activity_main.btn_mvp
import kotlinx.android.synthetic.main.activity_main.btn_mvvm
import kotlinx.android.synthetic.main.activity_main.btn_navgraph
import kotlinx.android.synthetic.main.activity_main.btn_recycler_api
import kotlinx.android.synthetic.main.activity_main.btn_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_recyclerview_grid
import kotlinx.android.synthetic.main.activity_main.btn_temprecyclerview
import kotlinx.android.synthetic.main.activity_main.btn_ui_element
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_one
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_recyclerview
import kotlinx.android.synthetic.main.activity_main.btn_viewpager_two
import kotlinx.android.synthetic.main.activity_main.btn_webview


class MainActivity : AppCompatActivity() {
    lateinit var TAG : String
     val  REQUEST_CODE_BACKGROUND = 100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        TAG = getString(R.string.mainactivity_log_tag)
        requestPermission()
        Log.d(TAG, "Oncreate Called")

        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let{
            val intent = Intent(applicationContext, BottomNavigationActivity::class.java)
            intent.putExtra(getString(R.string.key_intent),it)
            startActivity(intent)
        }
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
        btn_bottomnavigation.setOnClickListener {
            intent = Intent(applicationContext, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
        btn_fragments.setOnClickListener {
            intent = Intent(applicationContext, FragmentActivity::class.java)
            startActivity(intent)
        }
        btn_intent.setOnClickListener {
            intent = Intent(applicationContext, IntentActivity::class.java)
            resultLauncher.launch(intent)
        }
        btn_navgraph.setOnClickListener {
            intent = Intent(applicationContext, NavgraphActivity::class.java)
            startActivity(intent)
        }
       btn_webview.setOnClickListener {
            intent = Intent(applicationContext, WebviewActivity::class.java)
            startActivity(intent)
        }
        btn_recycler_api.setOnClickListener {
            intent = Intent(applicationContext, RecyclerWebActivity::class.java)
            startActivity(intent)
        }
        btn_mvp.setOnClickListener {
            intent = Intent(applicationContext,MVPActivity::class.java)
            startActivity(intent)
        }
        btn_mvc.setOnClickListener {
            intent = Intent(applicationContext,MVCActivity::class.java)
            startActivity(intent)
        }
        btn_mvvm.setOnClickListener {
            intent = Intent(applicationContext,MVVMActivity::class.java)
            startActivity(intent)
        }
        btn_inversebinding.setOnClickListener {
            intent = Intent(applicationContext,DataBindingActivity::class.java)
            startActivity(intent)
        }
        btn_temprecyclerview.setOnClickListener {
            intent = Intent(applicationContext,TempActivity::class.java)
            startActivity(intent)
        }
    }
    private fun requestPermission() {
        val hasForegroundPermission = ActivityCompat.checkSelfPermission(this,
            Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

        if (hasForegroundPermission) {
            val hasBackgroundPermission = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED
        } else {
            ActivityCompat.requestPermissions(this,
                arrayOf(Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION), REQUEST_CODE_BACKGROUND)
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