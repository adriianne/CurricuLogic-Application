package com.example.curriculogic.ui.enroll

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R
import com.example.curriculogic.data.model.AvailableCourse

class EnrollFragment : Fragment(), EnrollContract.View {

    private lateinit var presenter: EnrollPresenter
    private lateinit var adapter: EnrollAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enroll, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Setup Presenter
        presenter = EnrollPresenter(this)

        // 2. Load available courses
        presenter.loadAvailableCourses()
    }

    // --- View Interface Methods ---

    override fun showAvailableCourses(courses: List<AvailableCourse>) {
        view?.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.rvAvailableCourses)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            adapter = EnrollAdapter(courses) { course ->
                presenter.enrollCourse(course)
            }
            recyclerView.adapter = adapter
        }
    }

    override fun showLoading() {
        // Add a ProgressBar to fragment_enroll.xml if you want
    }

    override fun hideLoading() {
        // Hide ProgressBar here
    }

    override fun onEnrollSuccess(courseName: String) {
        Toast.makeText(
            requireContext(),
            "Successfully added $courseName!",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun onEnrollError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}