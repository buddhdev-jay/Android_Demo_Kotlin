package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.commit
import com.example.android_demo_kotlin.Fragments.FavoritesFragment
import com.example.android_demo_kotlin.Fragments.RecentFragment
import kotlinx.android.synthetic.main.activity_fragment.btn_favorite_fragment
import kotlinx.android.synthetic.main.activity_fragment.btn_recent_fragment

class FragmentActivity : AppCompatActivity() {
    private val TAG = getString(R.string.fragment_count)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        btn_favorite_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host,FavoritesFragment::class.java,null)
                addToBackStack(null)
            }
        }
        btn_recent_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host,RecentFragment::class.java,null)
                addToBackStack(null)
            }
            Log.d(TAG, supportFragmentManager.backStackEntryCount.toString())
        }
    }
}