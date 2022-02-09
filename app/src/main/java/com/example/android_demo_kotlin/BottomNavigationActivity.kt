package com.example.android_demo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.android_demo_kotlin.fragments.AddMessageFragment
import com.example.android_demo_kotlin.fragments.GalleryFragment
import com.example.android_demo_kotlin.fragments.ViewMessageFragment
import com.example.android_demo_kotlin.interfaces.Communicator
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigationActivity : AppCompatActivity(),Communicator {
    lateinit var bottomNavigationView: BottomNavigationView
    val getMessage = ViewMessageFragment()
    val galleryFragment = GalleryFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        supportFragmentManager.beginTransaction().add(R.id.fragment_container_bottomnavigation,galleryFragment).commit()
        setBottomNavigation()
        val str = intent.getStringExtra("key")
        if (intent.getStringExtra("key") != null) {
            val bundle = Bundle()
            bundle.putString("key",str)
            galleryFragment.arguments = bundle
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container_bottomnavigation,galleryFragment).commit()
        }
    }
    private fun setBottomNavigation() {
        bottomNavigationView.setOnNavigationItemSelectedListener {
            handleBottomNavigation(it.itemId)

        }
    }
    private fun handleBottomNavigation(menuItemId: Int): Boolean = when(menuItemId) {
        R.id.bottomnav_gallery ->{
            swapFragments(GalleryFragment())
            true
        }
        R.id.bottomnav_add_message ->{
            swapFragments(AddMessageFragment())
            true
        }
        R.id.bottomnav_view_message ->{
            swapFragments(ViewMessageFragment())
            true
        }
        else -> false
    }
    private fun swapFragments(fragment: Fragment,message: String? = "Hello") {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_bottomnavigation, fragment,message).commit()
    }

    override fun Datapass(data: String) {
        val bundle = Bundle()
        bundle.putString("message",data)
        getMessage.arguments = bundle
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_bottomnavigation,getMessage).commit()
    }
}