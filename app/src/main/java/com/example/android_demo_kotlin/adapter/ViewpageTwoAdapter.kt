package com.example.android_demo_kotlin.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.android_demo_kotlin.Fragments.FavoritesFragmenttwo
import com.example.android_demo_kotlin.Fragments.RecentFragmenttwo

class ViewpageTwoAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return 2
    }
    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FavoritesFragmenttwo()
            1 -> return RecentFragmenttwo()
        }
        return FavoritesFragmenttwo()
    }

}
