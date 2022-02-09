package com.example.android_demo_kotlin.adapter

import android.content.Context
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

class ViewpageroneAdapter(val context: Context,fm: FragmentManager) : FragmentPagerAdapter(fm) {

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
                return context.getString(R.string.tabtwo_string)
            }
            ONE -> {
                return context.getString(R.string.tabone_string)
            }
        }
        return super.getPageTitle(position)
    }
}