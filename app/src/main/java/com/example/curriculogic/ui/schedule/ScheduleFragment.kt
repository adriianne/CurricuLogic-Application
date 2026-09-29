package com.example.curriculogic.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R
import com.example.curriculogic.data.model.ScheduleItem

class ScheduleFragment : Fragment(), ScheduleContract.View {

    private lateinit var presenter: SchedulePresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_schedule, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = SchedulePresenter(this)
        presenter.loadSchedule()
    }

    // --- View Interface Methods ---

    override fun showSchedule(schedule: List<ScheduleItem>) {
        view?.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.rvSchedule)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = ScheduleAdapter(schedule)
        }
    }

    override fun showLoading() {
        // Optional: Add a ProgressBar to fragment_schedule.xml
    }

    override fun hideLoading() {
        // Hide ProgressBar here
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}