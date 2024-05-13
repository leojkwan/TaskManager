package com.leojkwan.taskmanager

object TaskManager {
    private var tasks = mutableListOf<Task>()

    fun addTask(task: Task) {
        tasks.add(task)
    }

    fun clearTasks() {
        tasks.clear()
    }

    fun removeTask(task: Task) {
        tasks.remove(task)
    }

    fun sortTasksByPriority(): List<Task> {
        return tasks.sortedBy { it.priority }
    }

    fun filterTasks(completed: Boolean): List<Task> {
        return tasks.filter { it.completed == completed }
    }

    fun getTaskStatus(index: Int): TaskStatus {
        if (index < 0 || index >= tasks.size) {
            throw IndexOutOfBoundsException("Index $index is out of bounds")
        }
        val task = tasks[index]
        return if (task.completed) {
            TaskStatus.Completed
        } else {
            TaskStatus.InProgress(task.priority)
        }
    }
}