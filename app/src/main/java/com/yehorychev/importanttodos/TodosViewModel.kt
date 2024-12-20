package com.yehorychev.importanttodos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TodosViewModel(val dao: TodosDao) : ViewModel() {
    var newTodoTitle = ""

    fun addTodo() {
        viewModelScope.launch {
            val todo = Todo()
            todo.title = newTodoTitle
            dao.insert(todo)
        }
    }
}