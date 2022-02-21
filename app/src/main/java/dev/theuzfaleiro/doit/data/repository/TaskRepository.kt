package dev.theuzfaleiro.doit.data.repository

import dagger.hilt.android.scopes.ViewModelScoped
import dev.theuzfaleiro.doit.data.dao.TaskDao
import dev.theuzfaleiro.doit.data.model.Task
import dev.theuzfaleiro.doit.domain.entity.TaskDto
import javax.inject.Inject
import kotlinx.coroutines.flow.map

@ViewModelScoped
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    fun getTaskById(id: Long) = taskDao.getTaskById(id)

    fun searchByTitle(title: String) = taskDao.searchTasksByTitle(title)

    fun getAllTasks() = taskDao.getAllTasks().map {
        it.map { taskDto ->
            Task(taskDto)
        }
    }

    fun sortedByLowPriority() = taskDao.getAllTasksByLowPriority()

    fun sortedByHighPriority() = taskDao.getAllTasksByHighPriority()

    suspend fun insertTask(taskDto: TaskDto) = taskDao.insertTask(taskDto)

    suspend fun updateTask(taskDto: TaskDto) = taskDao.updateTask(taskDto)

    suspend fun deleteTask(taskDto: TaskDto) = taskDao.deleteTask(taskDto)

    suspend fun deleteAllTasks() = taskDao.deleteAllTasks()
}