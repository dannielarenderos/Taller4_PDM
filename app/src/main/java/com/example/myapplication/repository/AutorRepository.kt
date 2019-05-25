package com.example.myapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.database.DAO.AutorDAO
import com.example.myapplication.database.Entities.AutorEntity

class AutorRepository (private val authorDao: AutorDAO) {

    val allAuthors: LiveData<List<AutorEntity>> = authorDao.getAutores()

    @WorkerThread
    suspend fun insertAuthor(author: AutorEntity){
        authorDao.insertAutor(author)
    }

}