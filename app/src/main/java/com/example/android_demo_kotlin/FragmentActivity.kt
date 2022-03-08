package com.example.android_demo_kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.example.android_demo_kotlin.Fragments.FavoritesFragment
import com.example.android_demo_kotlin.Fragments.RecentFragment
import kotlinx.android.synthetic.main.activity_fragment.btn_favorite_fragment
import kotlinx.android.synthetic.main.activity_fragment.btn_recent_fragment

class FragmentActivity : AppCompatActivity() {
    lateinit var TAG : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        TAG = getString(R.string.fragment_count_log_tag)
        btn_favorite_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host,FavoritesFragment::class.java,null)
                addToBackStack(null)
            }
        }
        val bundle = Bundle()
        bundle.putString("key", "From Activity")
        btn_recent_fragment.setOnClickListener {
            supportFragmentManager.commit {
                replace(R.id.fragment_host,RecentFragment::class.java,bundle)
                addToBackStack(null)
            }
            Log.d(TAG, supportFragmentManager.backStackEntryCount.toString())
        }
    }
}