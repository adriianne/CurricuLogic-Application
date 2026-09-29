package com.example.curriculogic.ui.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R
import com.example.curriculogic.data.model.ScheduleItem

class ScheduleAdapter(private val scheduleList: List<ScheduleItem>) :
    RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvStartTime: TextView = itemView.findViewById(R.id.tvScheduleStartTime)
        val tvEndTime: TextView = itemView.findViewById(R.id.tvScheduleEndTime)
        val tvCourseCode: TextView = itemView.findViewById(R.id.tvScheduleCourseCode)
        val tvCourseName: TextView = itemView.findViewById(R.id.tvScheduleCourseName)
        val tvRoom: TextView = itemView.findViewById(R.id.tvScheduleRoom)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val item = scheduleList[position]
        holder.tvStartTime.text = item.startTime
        holder.tvEndTime.text = item.endTime
        holder.tvCourseCode.text = item.courseCode
        holder.tvCourseName.text = item.courseName
        holder.tvRoom.text = "Room: ${item.room} • ${item.instructor}"
    }

    override fun getItemCount() = scheduleList.size
}