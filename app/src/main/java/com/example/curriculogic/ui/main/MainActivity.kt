package com.example.curriculogic.ui.main

import android.view.MenuItem
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.curriculogic.R
import com.example.curriculogic.ui.home.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.curriculogic.ui.curriculum.CurriculumFragment
import com.example.curriculogic.ui.profile.ProfileFragment
import com.example.curriculogic.ui.enroll.EnrollFragment
import com.example.curriculogic.ui.schedule.ScheduleFragment
import com.example.curriculogic.ui.ai.AiFragment
import com.example.curriculogic.ui.plan.PlanFragment



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav)

        // Load the Home Fragment by default when the app opens
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }

        // Handle navigation clicks
        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            var selectedFragment: Fragment? = null

            when (item.itemId) {
                R.id.nav_home -> selectedFragment = HomeFragment()
                R.id.nav_curriculum -> selectedFragment = CurriculumFragment()
                R.id.nav_ai -> selectedFragment = AiFragment()
                R.id.nav_plan -> selectedFragment = PlanFragment()
                R.id.nav_profile -> selectedFragment = ProfileFragment()
            }

            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
                true
            } else {
                false
            }
        }
    }
}