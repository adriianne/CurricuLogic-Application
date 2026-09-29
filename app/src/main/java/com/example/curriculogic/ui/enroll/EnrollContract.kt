package com.example.curriculogic.ui.enroll

import com.example.curriculogic.data.model.AvailableCourse

interface EnrollContract {
    interface View {
        fun showAvailableCourses(courses: List<AvailableCourse>)
        fun showLoading()
        fun hideLoading()
        fun onEnrollSuccess(courseName: String)
        fun onEnrollError(message: String)
    }
    interface Presenter {
        fun loadAvailableCourses()
        fun enrollCourse(course: AvailableCourse)
    }
}