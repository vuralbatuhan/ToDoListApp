package com.example.todolistapp.di

import android.content.Context
import androidx.room.Room
import com.example.todolistapp.data.datasource.ToDoDataSource
import com.example.todolistapp.data.repo.ToDoRepository
import com.example.todolistapp.room.ToDoDAO
import com.example.todolistapp.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideToDoRespoistory(tds: ToDoDataSource) : ToDoRepository {
        return ToDoRepository(tds)
    }

    @Provides
    @Singleton
    fun provideToDoDataSource(tdao: ToDoDAO) : ToDoDataSource {
        return ToDoDataSource(tdao)
    }

    @Provides
    @Singleton
    fun provideToDoDao(@ApplicationContext context: Context) : ToDoDAO {
        val vt = Room.databaseBuilder(context,Veritabani::class.java,"todosdb.db")
            .createFromAsset("todosdb.db").build()
        return vt.getToDoDao()
    }
}