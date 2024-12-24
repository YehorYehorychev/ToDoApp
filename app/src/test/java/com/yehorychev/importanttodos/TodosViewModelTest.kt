package com.yehorychev.importanttodos

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TodosViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    private lateinit var testDao: TodosDao
    private lateinit var todosViewModel: TodosViewModel
    private val emptyLiveDataList = MutableLiveData<List<Todo>>()
    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        every { testDao.getAll() } returns emptyLiveDataList
        todosViewModel = TodosViewModel(testDao)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `onTodoItemClicked sets todoId LiveData`() {
        // Given
        val todoId = 1L

        // When
        todosViewModel.onTodoItemClicked(todoId)

        // Then
        assertEquals(todosViewModel.navigateToTodo.value, todoId)
    }

    @Test
    fun `onTodoItemNavigated resets the navigateToTodo value to null`() {
        // Given
        todosViewModel.onTodoItemClicked(1L)

        // When
        todosViewModel.onTodoItemNavigated()

        // Then
        assertNull(todosViewModel.navigateToTodo.value)
    }
}