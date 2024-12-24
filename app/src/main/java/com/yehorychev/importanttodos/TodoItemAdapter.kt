package com.yehorychev.importanttodos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yehorychev.importanttodos.databinding.TodoItemBinding
import com.yehorychev.importanttodos.util.ColorProvider

class TodoItemAdapter(val clickListener: (todoId: Long) -> Unit) : ListAdapter<Todo, TodoItemAdapter.TodoItemViewHolder>(TodoItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder =
        TodoItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val item = getItem(position)
        val cardView = holder.binding.root as CardView
        holder.bind(item)
        cardView.setCardBackgroundColor(ColorProvider.getColorResourceId(position))
    }

    class TodoItemViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root) {

        companion object {
            fun inflateFrom(parent: ViewGroup): TodoItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = TodoItemBinding.inflate(layoutInflater, parent, false)
                return TodoItemViewHolder(binding)
            }
        }

        fun bind(item: Todo) {
            binding.todo = item
        }
    }
}