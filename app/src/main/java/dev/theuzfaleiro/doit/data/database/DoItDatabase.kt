package dev.theuzfaleiro.doit.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.theuzfaleiro.doit.data.dao.TaskDao
import dev.theuzfaleiro.doit.domain.entity.TaskDto

@Database(entities = [TaskDto::class], version = 1, exportSchema = false)
abstract class DoItDatabase : RoomDatabase() {
    abstract fun taskDao(): TaskDao
}