package com.example.curriculogic.ui.curriculum

import com.example.curriculogic.data.model.CurriculumCourse

sealed class CurriculumListItem {
    data class Header(val title: String) : CurriculumListItem()
    data class CourseItem(val course: CurriculumCourse) : CurriculumListItem()
}