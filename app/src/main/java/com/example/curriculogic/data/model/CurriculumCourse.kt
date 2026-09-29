package com.example.curriculogic.data.model

enum class CourseStatus {
    PASSED,
    IN_PROGRESS,
    LOCKED
}

data class CurriculumCourse(
    val code: String,
    val name: String,
    val units: Int,
    val prerequisite: String,
    val status: CourseStatus
)