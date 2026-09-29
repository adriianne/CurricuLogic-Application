package com.example.curriculogic.ui.curriculum

import com.example.curriculogic.data.model.CourseStatus
import com.example.curriculogic.data.model.CurriculumCourse

class CurriculumPresenter(private val view: CurriculumContract.View) :
    CurriculumContract.Presenter {

    override fun loadCurriculum() {
        view.showLoading()

        // --- TEMPORARY MOCK DATA ---
        // Later, this will come from Supabase (grouped by year + semester)
        val items = mutableListOf<CurriculumListItem>()

        // ================= YEAR 1 =================
        items.add(CurriculumListItem.Header("YEAR 1 • First Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 101", "Introduction to Computing", 3, "None", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 102", "Computer Programming 1", 3, "None", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("GE 101", "Understanding the Self", 3, "None", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("PE 101", "Physical Fitness", 2, "None", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("NSTP 1", "National Service Training Program 1", 3, "None", CourseStatus.PASSED)))

        items.add(CurriculumListItem.Header("YEAR 1 • Second Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 103", "Computer Programming 2", 3, "IT 102", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 104", "Discrete Structures 1", 3, "IT 101", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("GE 102", "Readings in Philippine History", 3, "None", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("PE 102", "Rhythmic Activities", 2, "PE 101", CourseStatus.PASSED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("NSTP 2", "National Service Training Program 2", 3, "NSTP 1", CourseStatus.PASSED)))

        // ================= YEAR 2 =================
        items.add(CurriculumListItem.Header("YEAR 2 • First Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 201", "Data Structures and Algorithms", 3, "IT 103", CourseStatus.IN_PROGRESS)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 202", "Object-Oriented Programming", 3, "IT 103", CourseStatus.IN_PROGRESS)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 203", "Discrete Structures 2", 3, "IT 104", CourseStatus.IN_PROGRESS)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("GE 201", "Purposive Communication", 3, "None", CourseStatus.IN_PROGRESS)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("PE 201", "Rhythmic Activities", 2, "PE 102", CourseStatus.IN_PROGRESS)))

        items.add(CurriculumListItem.Header("YEAR 2 • Second Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 204", "Information Management", 3, "IT 201", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 205", "Quantitative Methods", 3, "IT 203", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 206", "Applications Development", 3, "IT 202", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("GE 202", "Mathematics in the Modern World", 3, "None", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("GE 203", "The Contemporary World", 3, "None", CourseStatus.LOCKED)))

        // ================= YEAR 3 =================
        items.add(CurriculumListItem.Header("YEAR 3 • First Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 301", "Systems Integration", 3, "IT 204", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 302", "Networking 1", 3, "IT 205", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 303", "Human Computer Interaction", 3, "IT 206", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("GE 301", "Ethics", 3, "None", CourseStatus.LOCKED)))

        items.add(CurriculumListItem.Header("YEAR 3 • Second Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 304", "Networking 2", 3, "IT 302", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 305", "Software Engineering", 3, "IT 303", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 306", "Capstone 1", 3, "IT 301", CourseStatus.LOCKED)))

        // ================= YEAR 4 =================
        items.add(CurriculumListItem.Header("YEAR 4 • First Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 401", "Capstone 2", 3, "IT 306", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 402", "Practicum 1", 3, "IT 305", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 403", "Emerging Technologies", 3, "IT 304", CourseStatus.LOCKED)))

        items.add(CurriculumListItem.Header("YEAR 4 • Second Semester"))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 404", "Practicum 2", 6, "IT 402", CourseStatus.LOCKED)))
        items.add(CurriculumListItem.CourseItem(CurriculumCourse("IT 405", "Professional Ethics in IT", 3, "GE 301", CourseStatus.LOCKED)))

        // ---------------------------

        view.hideLoading()
        view.showCurriculum(items)
    }
}