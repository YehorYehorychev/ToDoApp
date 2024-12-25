package com.yehorychev.importanttodos

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.hasDescendant
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodosIntegrationTest {
    private val newTodoText = "Espresso Test Todo"
    private val updatedTodoText = "Updated Espresso Todo"

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun addTodo_updateIt_and_deleteIt() {
        // Add new todo item
        onView(withId(R.id.todo_title)).perform(typeText(newTodoText))
        onView(withId(R.id.todo_save_button)).perform(click())

        // Assertion
        onView(withId(R.id.todo_name))
            .check(matches(withText(newTodoText)))
            .perform(click())
//        onView(allOf(withId(R.id.todo_name), withText(newTodoText))).check(matches(isDisplayed()))

        // Update todo item
        onView(withId(R.id.todo_name)).perform(replaceText(updatedTodoText))
        onView(withId(R.id.update_button)).perform(click())
        onView(withId(R.id.todo_name))
            .check(matches(withText(updatedTodoText)))
            .perform(click())

        // Delete todo
        onView(withId(R.id.delete_button)).perform(click())
        onView(withId(R.id.todos_list)).check(matches(not(hasDescendant(withText(updatedTodoText)))))
    }
}