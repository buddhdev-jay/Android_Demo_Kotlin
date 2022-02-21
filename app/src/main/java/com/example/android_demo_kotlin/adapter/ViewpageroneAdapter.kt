package com.example.android_demo_kotlin.adapter

import android.provider.Settings.Global.getString
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.android_demo_kotlin.Fragments.FavoritesFragment
import com.example.android_demo_kotlin.Fragments.RecentFragment
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.TW0
import com.example.android_demo_kotlin.utils.ZERO

class ViewpageroneAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getCount(): Int {
        return TW0
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            ZERO -> {
                FavoritesFragment()
            }
            ONE -> {
                RecentFragment()
            }
            else -> {
                FavoritesFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            ZERO -> {
                return (R.string.tab1).toString()
            }
            ONE -> {
                return (R.string.tab2).toString()
            }
        }
        return super.getPageTitle(position)
    }
}