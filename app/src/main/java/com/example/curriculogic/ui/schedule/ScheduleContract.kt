package com.example.curriculogic.ui.schedule

import com.example.curriculogic.data.model.ScheduleItem

interface ScheduleContract {
    interface View {
        fun showSchedule(schedule: List<ScheduleItem>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface Presenter {
        fun loadSchedule()
    }
}