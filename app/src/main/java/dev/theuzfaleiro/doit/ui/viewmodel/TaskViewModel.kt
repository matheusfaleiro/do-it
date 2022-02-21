package dev.theuzfaleiro.doit.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.theuzfaleiro.doit.data.model.Task
import dev.theuzfaleiro.doit.data.repository.TaskRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskRepository: TaskRepository) : ViewModel() {

    private val _allTasks: MutableStateFlow<List<Task>> = MutableStateFlow(emptyList())

    val allTasks: MutableStateFlow<List<Task>>
        get() = _allTasks

    fun getAllTasks() = viewModelScope.launch {
        taskRepository.getAllTasks().collect {
            _allTasks.value = it
        }
    }
}