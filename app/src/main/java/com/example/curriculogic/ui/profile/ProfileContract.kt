package com.example.curriculogic.ui.profile

import com.example.curriculogic.data.model.UserProfile

interface ProfileContract {
    interface View {
        fun showProfile(profile: UserProfile)
        fun showLoading()
        fun hideLoading()
        fun onLogoutSuccess()
    }

    interface Presenter {
        fun loadProfile()
        fun logout()
    }
}