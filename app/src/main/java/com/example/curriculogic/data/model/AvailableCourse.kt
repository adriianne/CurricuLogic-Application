package com.example.curriculogic.data.model

data class AvailableCourse(
    val code: String,
    val name: String,
    val units: Int,
    val prerequisite: String
)