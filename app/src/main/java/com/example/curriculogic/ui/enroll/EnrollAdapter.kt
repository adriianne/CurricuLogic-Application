package com.example.curriculogic.ui.enroll

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R
import com.example.curriculogic.data.model.AvailableCourse

class EnrollAdapter(
    private val courseList: List<AvailableCourse>,
    private val onAddClick: (AvailableCourse) -> Unit
) : RecyclerView.Adapter<EnrollAdapter.EnrollViewHolder>() {

    class EnrollViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCode: TextView = itemView.findViewById(R.id.tvEnrollCourseCode)
        val tvName: TextView = itemView.findViewById(R.id.tvEnrollCourseName)
        val tvUnits: TextView = itemView.findViewById(R.id.tvEnrollCourseUnits)
        val btnAdd: Button = itemView.findViewById(R.id.btnAddCourse)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnrollViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_enroll_course, parent, false)
        return EnrollViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnrollViewHolder, position: Int) {
        val course = courseList[position]
        holder.tvCode.text = course.code
        holder.tvName.text = course.name
        holder.tvUnits.text = "${course.units} Units • Prerequisite: ${course.prerequisite}"

        holder.btnAdd.setOnClickListener {
            onAddClick(course)
        }
    }

    override fun getItemCount() = courseList.size
}