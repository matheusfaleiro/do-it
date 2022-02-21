package dev.theuzfaleiro.di.module

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import dev.theuzfaleiro.doit.data.database.DoItDatabase
import dev.theuzfaleiro.doit.util.Constants.TODO_DATABASE_NAME
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DoItDatabaseModule {

    @Singleton
    @Provides
    fun providesDoItDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        DoItDatabase::class.java,
        TODO_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun providesDoItDao(doItDatabase: DoItDatabase) = doItDatabase.taskDao()
}