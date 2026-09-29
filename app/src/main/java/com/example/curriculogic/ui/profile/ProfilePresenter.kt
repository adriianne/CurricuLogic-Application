package com.example.curriculogic.ui.profile

import com.example.curriculogic.data.model.UserProfile

class ProfilePresenter(private val view: ProfileContract.View) : ProfileContract.Presenter {

    override fun loadProfile() {
        view.showLoading()

        // --- TEMPORARY MOCK DATA ---
        // Later, this will call UserRepository to fetch from Supabase!
        val dummyProfile = UserProfile(
            name = "Althea Villanueva",
            studentId = "2024-00123",
            program = "BSIT",
            yearLevel = 2
        )
        // ---------------------------

        view.hideLoading()
        view.showProfile(dummyProfile)
    }

    override fun logout() {
        // Here you would clear the Supabase session.
        // For now, we just tell the View to navigate.
        view.onLogoutSuccess()
    }
}