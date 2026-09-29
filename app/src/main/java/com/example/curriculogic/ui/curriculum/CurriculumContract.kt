package com.example.curriculogic.ui.curriculum

interface CurriculumContract {
    interface View {
        fun showCurriculum(items: List<CurriculumListItem>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface Presenter {
        fun loadCurriculum()
    }
}