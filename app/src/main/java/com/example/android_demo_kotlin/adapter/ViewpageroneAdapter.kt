package com.example.android_demo_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.android_demo_kotlin.Fragments.FavoritesFragment
import com.example.android_demo_kotlin.Fragments.RecentFragment

class ViewpageroneAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                FavoritesFragment()
            }
            1 -> {
                RecentFragment()
            }
            else -> {
                FavoritesFragment()
            }
        }
    }
    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> {
                return "Tab 1"
            }
            1 -> {
                return "Tab 2"
            }
        }
        return super.getPageTitle(position)
    }
}