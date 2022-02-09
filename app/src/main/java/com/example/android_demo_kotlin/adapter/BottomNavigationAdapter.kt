package com.example.android_demo_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.android_demo_kotlin.Fragments.FavoritesFragment
import com.example.android_demo_kotlin.Fragments.ProfileFragment
import com.example.android_demo_kotlin.Fragments.RecentFragment

class BottomNavigationAdapter(var fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getCount(): Int {
        return 3
    }
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> RecentFragment()
            1 -> FavoritesFragment()
            2 -> ProfileFragment()
            else -> RecentFragment()
        }
    }
}