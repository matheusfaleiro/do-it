package dev.theuzfaleiro.doit.data.model

import dev.theuzfaleiro.doit.domain.entity.TaskDto

data class Task(
    val id: Int,
    val title: String,
    val description: String,
    val priority: Priority,
) {
    constructor(taskDto: TaskDto) : this(
        id = taskDto.id,
        title = taskDto.title,
        description = taskDto.description,
        priority = Priority.from(taskDto.priorityDto.ordinal)
    )
}
