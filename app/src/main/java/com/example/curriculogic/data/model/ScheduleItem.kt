package com.example.curriculogic.data.model

data class ScheduleItem(
    val day: String,
    val startTime: String,
    val endTime: String,
    val courseCode: String,
    val courseName: String,
    val room: String,
    val instructor: String
)