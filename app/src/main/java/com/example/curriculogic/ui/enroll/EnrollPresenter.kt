package com.example.curriculogic.ui.enroll

import com.example.curriculogic.data.model.AvailableCourse

class EnrollPresenter(private val view: EnrollContract.View) : EnrollContract.Presenter {

    // Keeps track of what the student has already added this session
    private val enrolledCodes = mutableSetOf<String>()

    override fun loadAvailableCourses() {
        view.showLoading()

        // --- TEMPORARY MOCK DATA ---
        // Later, this will come from Supabase (filtered by prerequisites met)
        val dummyCourses = listOf(
            AvailableCourse("IT 201", "Data Structures and Algorithms", 3, "IT 102"),
            AvailableCourse("IT 202", "Object-Oriented Programming", 3, "IT 102"),
            AvailableCourse("IT 203", "Discrete Structures 2", 3, "IT 101"),
            AvailableCourse("GE 201", "Purposive Communication", 3, "None"),
            AvailableCourse("GE 202", "Mathematics in the Modern World", 3, "None"),
            AvailableCourse("PE 201", "Rhythmic Activities", 2, "PE 101")
        )
        // ---------------------------

        view.hideLoading()
        view.showAvailableCourses(dummyCourses)
    }

    override fun enrollCourse(course: AvailableCourse) {
        // Check if already enrolled this session
        if (enrolledCodes.contains(course.code)) {
            view.onEnrollError("${course.code} is already in your enrolled list!")
            return
        }

        view.showLoading()

        // --- SIMULATE A NETWORK CALL TO SUPABASE ---
        // Later, this is where you would call CourseRepository.enroll(course)
        enrolledCodes.add(course.code)
        // -------------------------------------------

        view.hideLoading()
        view.onEnrollSuccess(course.name)
    }
}