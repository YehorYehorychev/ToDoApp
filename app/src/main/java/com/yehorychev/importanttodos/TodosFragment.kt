package com.yehorychev.importanttodos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.yehorychev.importanttodos.databinding.FragmentTodosBinding

class TodosFragment : androidx.fragment.app.Fragment() {

    private var _binding: FragmentTodosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodosBinding.inflate(inflater, container, false)

        val application = requireNotNull(this.activity).application
        val dao = TodosDatabase.getInstance(application).todosDao
        val viewModelFactory = TodosViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory)[TodosViewModel::class.java]
        val adapter = TodoItemAdapter { todoId ->
            viewModel.onTodoItemClicked(todoId)
        }
        binding.viewModel = viewModel
        binding.todosList.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.todos.observe(viewLifecycleOwner) { todosList ->
            todosList?.let {
                adapter.submitList(it)
            }
        }
        return binding.root
    }
}