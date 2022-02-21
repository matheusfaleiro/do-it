package dev.theuzfaleiro.doit.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import dev.theuzfaleiro.doit.data.model.Task
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    @Query("SELECT * FROM TASK_TABLE")
    fun getAllTasks(): Flow<List<Task>>

    @Query("SELECT * FROM TASK_TABLE WHERE id = :id")
    fun getTaskById(id: Long): Flow<Task>

    @Insert(onConflict = REPLACE)
    suspend fun insertTask(task: Task)

    @Update
    suspend fun updateTask(task: Task)

    @Delete
    suspend fun deleteTask(task: Task)

    @Query("DELETE FROM TASK_TABLE")
    suspend fun deleteAllTasks()

    @Query("SELECT * FROM TASK_TABLE WHERE TITLE LIKE :searchQuery OR DESCRIPTION LIKE :searchQuery")
    fun searchTasksByTitle(searchQuery: String): Flow<List<Task>>

    @Query("SELECT * FROM TASK_TABLE ORDER BY CASE WHEN PRIORITY LIKE 'L%' THEN 1 WHEN PRIORITY LIKE 'M%' THEN 2 WHEN PRIORITY LIKE 'H%' THEN 3 END")
    fun getAllTasksByPriority(): Flow<List<Task>>

    @Query("SELECT * FROM TASK_TABLE ORDER BY CASE WHEN PRIORITY LIKE 'H%' THEN 1 WHEN PRIORITY LIKE 'M%' THEN 2 WHEN PRIORITY LIKE 'L%' THEN 3 END")
    fun getAllTasksByHighPriority(): Flow<List<Task>>
}