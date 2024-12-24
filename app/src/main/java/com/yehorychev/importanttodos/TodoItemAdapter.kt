package com.yehorychev.importanttodos

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yehorychev.importanttodos.util.ColorProvider

class TodoItemAdapter : ListAdapter<Todo, TodoItemAdapter.TodoItemViewHolder>(TodoItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder =
        TodoItemViewHolder.inflateFrom(parent)

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
        holder.rootView.setCardBackgroundColor(ColorProvider.getColorResourceId(position))
    }

    class TodoItemViewHolder(val rootView: CardView) : RecyclerView.ViewHolder(rootView) {
        private val todoTitle = rootView.findViewById<CheckBox>(R.id.todo_name)

        companion object {
            fun inflateFrom(parent: ViewGroup): TodoItemViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.todo_item, parent, false) as CardView
                return TodoItemViewHolder(view)
            }
        }

        fun bind(item: Todo) {
            todoTitle.isChecked = item.completed
            todoTitle.text = item.title
        }
    }
}