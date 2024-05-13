package com.leojkwan.taskmanager

data class Task(
    val title: String,
    var priority: Priority,
    var completed: Boolean
)

enum class Priority {
    HIGH,
    MEDIUM,
    LOW
}

sealed class TaskStatus {
    data class InProgress(val priority: Priority): TaskStatus()
    data object Completed: TaskStatus()
}
