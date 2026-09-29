package com.example.curriculogic.ui.schedule

import com.example.curriculogic.data.model.ScheduleItem

class SchedulePresenter(private val view: ScheduleContract.View) : ScheduleContract.Presenter {

    override fun loadSchedule() {
        view.showLoading()

        // --- TEMPORARY MOCK DATA ---
        // Later, this will come from Supabase (schedule table)
        val dummySchedule = listOf(
            ScheduleItem("Monday", "7:30 AM", "9:00 AM", "IT 201", "Data Structures and Algorithms", "Lab 302", "Prof. Santos"),
            ScheduleItem("Monday", "9:30 AM", "11:00 AM", "IT 202", "Object-Oriented Programming", "Lab 305", "Prof. Reyes"),
            ScheduleItem("Monday", "1:00 PM", "2:30 PM", "GE 201", "Purposive Communication", "Room 210", "Prof. Cruz"),
            ScheduleItem("Tuesday", "7:30 AM", "9:00 AM", "IT 203", "Discrete Structures 2", "Room 401", "Prof. Lim"),
            ScheduleItem("Tuesday", "10:00 AM", "11:30 AM", "PE 201", "Rhythmic Activities", "Gymnasium", "Coach Tan"),
            ScheduleItem("Wednesday", "8:00 AM", "10:00 AM", "IT 201", "Data Structures Lab", "Lab 302", "Prof. Santos"),
            ScheduleItem("Thursday", "9:00 AM", "10:30 AM", "GE 202", "Mathematics in the Modern World", "Room 215", "Prof. Garcia"),
            ScheduleItem("Friday", "1:00 PM", "2:30 PM", "IT 202", "OOP Lab", "Lab 305", "Prof. Reyes")
        )
        // ---------------------------

        view.hideLoading()
        view.showSchedule(dummySchedule)
    }
}