package com.leojkwan.taskmanager
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class TaskManagerTest {
    @Before
    fun setUp() {
        TaskManager.clearTasks()
    }

    @Test
    fun testAddAndRemoveTask() {
        val task1 = Task("Task 1", Priority.HIGH, false)
        TaskManager.addTask(task1)
        TaskManager.addTask(Task("Task 2", Priority.HIGH, true))
        assertEquals(TaskManager.filterTasks(false).size, 1)
        TaskManager.removeTask(task1)
        assertEquals(TaskManager.filterTasks(false).size, 0)
    }

    @Test
    fun testGettingTaskError() {
        val task1 = Task("Task 1", Priority.HIGH, false)
        TaskManager.addTask(task1)
        assertEquals(TaskManager.getTaskStatus(0), TaskStatus.InProgress(Priority.HIGH))
    }

    @Test
    fun testSortTasks() {
        val low = Task("Task 1", Priority.LOW, false)
        val medium = Task("Task 2", Priority.MEDIUM, false)
        val high = Task("Task 3", Priority.HIGH, false)

        TaskManager.addTask(low)
        TaskManager.addTask(medium)
        TaskManager.addTask(high)

        val sortedTasks = TaskManager.sortTasksByPriority()
        val expected = listOf(high, medium, low)
        assertEquals(sortedTasks, expected)
    }

    @Test
    fun testGetTaskStatus() {
        val task1 = Task("Task 1", Priority.HIGH, false)
        TaskManager.addTask(task1)
        val status = TaskManager.getTaskStatus(0)
        assertTrue(status is TaskStatus.InProgress)
    }
}