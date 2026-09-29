package com.example.curriculogic.ui.ai

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.curriculogic.R
import com.example.curriculogic.data.model.ChatMessage

class AiFragment : Fragment(), AiContract.View {

    private lateinit var presenter: AiPresenter
    private lateinit var adapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ai_advisor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = AiPresenter(this)

        view.findViewById<RecyclerView>(R.id.rvChat).apply {
            layoutManager = LinearLayoutManager(requireContext())
        }

        view.findViewById<Button>(R.id.btnSend).setOnClickListener {
            val message = view.findViewById<EditText>(R.id.etMessage).text.toString()
            presenter.sendMessage(message)
            view.findViewById<EditText>(R.id.etMessage).text.clear()
        }
    }

    override fun showMessages(messages: List<ChatMessage>) {
        view?.findViewById<RecyclerView>(R.id.rvChat)?.let { recyclerView ->
            adapter = ChatAdapter(messages)
            recyclerView.adapter = adapter
            if (messages.isNotEmpty()) {
                recyclerView.scrollToPosition(messages.size - 1)
            }
        }
    }

    override fun showLoading() {
        // Optional: Disable the send button or show a typing indicator
    }

    override fun hideLoading() {
        // Optional: Re-enable the send button
    }

    override fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}