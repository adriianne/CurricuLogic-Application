package com.example.curriculogic.ui.home

import com.example.curriculogic.data.model.Course

interface HomeContract {
    interface View {
        fun showCourses(courses: List<Course>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface Presenter {
        fun loadEnrolledCourses()
    }
}