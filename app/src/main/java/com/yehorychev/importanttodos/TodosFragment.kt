package com.yehorychev.importanttodos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yehorychev.importanttodos.databinding.FragmentTodosBinding

class TodosFragment : androidx.fragment.app.Fragment() {

    private var _binding: FragmentTodosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTodosBinding.inflate(inflater, container, false)
        return binding.root
    }
}