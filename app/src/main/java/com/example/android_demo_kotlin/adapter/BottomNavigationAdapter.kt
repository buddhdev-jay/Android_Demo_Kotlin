package com.example.android_demo_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.android_demo_kotlin.fragments.AddMessageFragment
import com.example.android_demo_kotlin.fragments.GalleryFragment
import com.example.android_demo_kotlin.fragments.ViewMessageFragment
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.THREE
import com.example.android_demo_kotlin.utils.ZERO
import com.example.android_demo_kotlin.utils.TWO

class BottomNavigationAdapter(var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return THREE
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            ZERO -> GalleryFragment()
            ONE -> AddMessageFragment()
            TWO -> ViewMessageFragment()
            else -> GalleryFragment()
        }
    }
}