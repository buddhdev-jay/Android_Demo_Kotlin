package com.example.android_demo_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.android_demo_kotlin.Fragments.FavoritesFragment
import com.example.android_demo_kotlin.Fragments.ProfileFragment
import com.example.android_demo_kotlin.Fragments.RecentFragment
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.THREE
import com.example.android_demo_kotlin.utils.TW0
import com.example.android_demo_kotlin.utils.ZERO

class BottomNavigationAdapter(var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

    override fun getCount(): Int {
        return THREE
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            ZERO -> RecentFragment()
            ONE -> FavoritesFragment()
            TW0 -> ProfileFragment()
            else -> RecentFragment()
        }
    }
}