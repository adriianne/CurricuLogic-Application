package com.example.curriculogic.ui.plan

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.curriculogic.ui.enroll.EnrollFragment
import com.example.curriculogic.ui.schedule.ScheduleFragment

class PlanPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> EnrollFragment()
            1 -> ScheduleFragment()
            else -> EnrollFragment()
        }
    }
}