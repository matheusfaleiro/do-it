package dev.theuzfaleiro.doit.domain.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.theuzfaleiro.doit.util.Constants.TODO_DATABASE_TASK_TABLE_NAME

@Entity(tableName = TODO_DATABASE_TASK_TABLE_NAME)
data class TaskDto(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo(name = "TITLE")
    val title: String,
    @ColumnInfo(name = "DESCRIPTION")
    val description: String,
    @ColumnInfo(name = "PRIORITY")
    val priorityDto: PriorityDto,
)
