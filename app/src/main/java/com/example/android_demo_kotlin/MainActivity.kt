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
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.btn_bottomnavigation
import kotlinx.android.synthetic.main.activity_main.btn_coordinator
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
import kotlinx.android.synthetic.main.activity_main.btn_navigationview
import kotlinx.android.synthetic.main.activity_main.btn_permission
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
        Log.d(TAG, "Oncreate Called")

        (intent.getParcelableExtra<Parcelable>(Intent.EXTRA_STREAM) as? Uri)?.let{
            val intent = Intent(this, BottomNavigationActivity::class.java)
            intent.putExtra(getString(R.string.key_intent),it)
            startActivity(intent)
        }
        btn_kotlin_basic.setOnClickListener {
            intent = Intent(this, Kotlin_Basic::class.java)
            startActivity(intent)
        }
        btn_ui_element.setOnClickListener {
            intent = Intent(this, UiElementActivity::class.java)
            startActivity(intent)
        }
        btn_layouts.setOnClickListener {
            intent = Intent(this, LayoutActivity::class.java)
            intent.putExtra(getString(R.string.name_key_intent), "Jay")
            startActivity(intent)
        }
        btn_listview.setOnClickListener {
            intent = Intent(this, ListviewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview.setOnClickListener {
            intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_recyclerview_grid.setOnClickListener {
            intent = Intent(this, GridLayoutRecyclerViewActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_one.setOnClickListener {
            intent = Intent(this, ViewPageroneActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_two.setOnClickListener {
            intent = Intent(this, ViewPagertwoActivity::class.java)
            startActivity(intent)
        }
        btn_viewpager_recyclerview.setOnClickListener {
            intent = Intent(this, ViewpagertwoRecyclerviewActivity::class.java)
            startActivity(intent)
        }
        btn_expandable_recyclerview.setOnClickListener {
            intent = Intent(this, ExpandableRecyclerviewActivity::class.java)
            startActivity(intent)
        }
        btn_expandable_listview.setOnClickListener {
            intent = Intent(this, ExpandableListviewActivity::class.java)
            startActivity(intent)
        }
        btn_bottomnavigation.setOnClickListener {
            intent = Intent(this, BottomNavigationActivity::class.java)
            startActivity(intent)
        }
        btn_fragments.setOnClickListener {
            intent = Intent(this, FragmentActivity::class.java)
            startActivity(intent)
        }
        btn_intent.setOnClickListener {
            intent = Intent(this, IntentActivity::class.java)
            resultLauncher.launch(intent)
        }
        btn_navgraph.setOnClickListener {
            intent = Intent(this, NavgraphActivity::class.java)
            startActivity(intent)
        }
       btn_webview.setOnClickListener {
            intent = Intent(this, WebviewActivity::class.java)
            startActivity(intent)
        }
        btn_recycler_api.setOnClickListener {
            intent = Intent(this, RecyclerWebActivity::class.java)
            startActivity(intent)
        }
        btn_mvp.setOnClickListener {
            intent = Intent(this,MVPActivity::class.java)
            startActivity(intent)
        }
        btn_mvc.setOnClickListener {
            intent = Intent(this,MVCActivity::class.java)
            startActivity(intent)
        }
        btn_mvvm.setOnClickListener {
            intent = Intent(this,MVVMActivity::class.java)
            startActivity(intent)
        }
        btn_inversebinding.setOnClickListener {
            intent = Intent(this,DataBindingActivity::class.java)
            startActivity(intent)
        }
        btn_temprecyclerview.setOnClickListener {
            intent = Intent(this,TempActivity::class.java)
            startActivity(intent)
        }
        btn_permission.setOnClickListener {
            intent = Intent(this,PermissionActivity::class.java)
            startActivity(intent)
        }
        btn_navigationview.setOnClickListener {
            intent = Intent(this,NavigationViewActivity::class.java)
            startActivity(intent)
        }
        btn_coordinator.setOnClickListener {
            intent = Intent(this,CoordinatorLayoutActivity::class.java)
            startActivity(intent)
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