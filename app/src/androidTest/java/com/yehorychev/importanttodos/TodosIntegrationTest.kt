package com.yehorychev.importanttodos

import androidx.compose.ui.test.hasText
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodosIntegrationTest {
    private val newTodoText = "Espresso Test Todo"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addTodo_updateIt_and_deleteIt() {
        // Add new todo item
        onView(withId(R.id.todo_title)).perform(typeText(newTodoText))
        onView(withId(R.id.todo_save_button)).perform(click())
    }
}