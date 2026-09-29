package com.example.curriculogic.ui.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.curriculogic.R
import com.example.curriculogic.data.model.UserProfile
import com.example.curriculogic.ui.auth.LoginActivity

class ProfileFragment : Fragment(), ProfileContract.View {

    private lateinit var presenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup Presenter
        presenter = ProfilePresenter(this)

        // 2. Setup Logout Button
        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            presenter.logout()
        }

        // 3. Load Profile Data
        presenter.loadProfile()
    }

    // --- View Interface Methods ---

    override fun showProfile(profile: UserProfile) {
        view?.findViewById<TextView>(R.id.tvStudentName)?.text = profile.name
        view?.findViewById<TextView>(R.id.tvStudentDetails)?.text =
            "${profile.program} - Year ${profile.yearLevel} • ID: ${profile.studentId}"
    }

    override fun showLoading() {
        // Add ProgressBar to fragment_profile.xml if you want to show loading
    }

    override fun hideLoading() {
        // Hide ProgressBar here
    }

    override fun onLogoutSuccess() {
        Toast.makeText(requireContext(), "Logged out successfully", Toast.LENGTH_SHORT).show()
        // Go back to Login Screen
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
        requireActivity().finish() // Close MainActivity so user can't go back
    }
}