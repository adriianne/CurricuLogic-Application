package com.example.curriculogic.ui.curriculum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R

class CurriculumFragment : Fragment(), CurriculumContract.View {

    private lateinit var presenter: CurriculumPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_curriculum, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = CurriculumPresenter(this)
        presenter.loadCurriculum()
    }

    override fun showCurriculum(items: List<CurriculumListItem>) {
        view?.let {
            val recyclerView = it.findViewById<RecyclerView>(R.id.rvCurriculum)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            recyclerView.adapter = CurriculumAdapter(items)
        }
    }

    override fun showLoading() {
        // Add ProgressBar to fragment_curriculum.xml if desired
    }

    override fun hideLoading() {
        // Hide ProgressBar here
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}