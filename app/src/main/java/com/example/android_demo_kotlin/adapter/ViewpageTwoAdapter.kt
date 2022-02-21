package com.example.android_demo_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_demo_kotlin.Fragments.FavoritesFragmenttwo
import com.example.android_demo_kotlin.Fragments.RecentFragmenttwo
import com.example.android_demo_kotlin.utils.ONE
import com.example.android_demo_kotlin.utils.TW0
import com.example.android_demo_kotlin.utils.ZERO

class ViewpageTwoAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return TW0
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            ZERO -> return FavoritesFragmenttwo()
            ONE -> return RecentFragmenttwo()
        }
        return FavoritesFragmenttwo()
    }

}
