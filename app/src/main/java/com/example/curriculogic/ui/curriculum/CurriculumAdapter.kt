package com.example.curriculogic.ui.curriculum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R
import com.example.curriculogic.data.model.CourseStatus

class CurriculumAdapter(private val items: List<CurriculumListItem>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_COURSE = 1
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is CurriculumListItem.Header -> TYPE_HEADER
            is CurriculumListItem.CourseItem -> TYPE_COURSE
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == TYPE_HEADER) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_curriculum_header, parent, false)
            HeaderViewHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_curriculum_course, parent, false)
            CourseViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (val item = items[position]) {
            is CurriculumListItem.Header -> {
                (holder as HeaderViewHolder).tvHeaderTitle.text = item.title
            }
            is CurriculumListItem.CourseItem -> {
                val courseHolder = holder as CourseViewHolder
                val course = item.course

                courseHolder.tvCourseCode.text = course.code
                courseHolder.tvCourseName.text = course.name
                courseHolder.tvPrereq.text = "Prerequisite: ${course.prerequisite}"

                // Apply status styling
                val context = courseHolder.itemView.context
                when (course.status) {
                    CourseStatus.PASSED -> {
                        courseHolder.tvStatusBadge.text = "PASSED"
                        courseHolder.tvStatusBadge.setBackgroundResource(R.drawable.badge_passed)
                        courseHolder.vStatusDot.setBackgroundColor(
                            ContextCompat.getColor(context, android.R.color.holo_green_dark)
                        )
                    }
                    CourseStatus.IN_PROGRESS -> {
                        courseHolder.tvStatusBadge.text = "IN PROGRESS"
                        courseHolder.tvStatusBadge.setBackgroundResource(R.drawable.badge_in_progress)
                        courseHolder.vStatusDot.setBackgroundColor(
                            ContextCompat.getColor(context, android.R.color.holo_blue_dark)
                        )
                    }
                    CourseStatus.LOCKED -> {
                        courseHolder.tvStatusBadge.text = "LOCKED"
                        courseHolder.tvStatusBadge.setBackgroundResource(R.drawable.badge_locked)
                        courseHolder.vStatusDot.setBackgroundColor(
                            ContextCompat.getColor(context, android.R.color.darker_gray)
                        )
                    }
                }
            }
        }
    }

    override fun getItemCount() = items.size

    class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvHeaderTitle: TextView = itemView.findViewById(R.id.tvHeaderTitle)
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCourseCode: TextView = itemView.findViewById(R.id.tvCurrCourseCode)
        val tvCourseName: TextView = itemView.findViewById(R.id.tvCurrCourseName)
        val tvPrereq: TextView = itemView.findViewById(R.id.tvCurrCoursePrereq)
        val tvStatusBadge: TextView = itemView.findViewById(R.id.tvStatusBadge)
        val vStatusDot: View = itemView.findViewById(R.id.vStatusDot)
    }
}