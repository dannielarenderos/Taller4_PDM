package com.example.myapplication.repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.myapplication.database.DAO.LibroDAO
import com.example.myapplication.database.DAO.LibroxAutorDAO
import com.example.myapplication.database.DAO.LibroxTagDAO
import com.example.myapplication.database.Entities.LibroEntity
import com.example.myapplication.database.Entities.LibroxAutorEntity
import com.example.myapplication.database.Entities.LibroxTagEntity

class LibroRepository(
    private val bookDao: LibroDAO,
    private val bookxauthorDao: LibroxAutorDAO,
    private val bookxtagDao: LibroxTagDAO
) {

    val allBooks: LiveData<List<LibroEntity>> = bookDao.getLibros()

    val allFavs: LiveData<List<LibroEntity>> = bookDao.getFavs()


    @WorkerThread
    suspend fun insertBook(libro: LibroEntity) {
        bookDao.insertLibro(libro)
    }

    @WorkerThread
    suspend fun insertBookxAuthor(libroxAutor: LibroxAutorEntity) {
        bookxauthorDao.insertarLibroxAutor(libroxAutor)
    }


    @WorkerThread
    suspend fun insertBookxTag(libroxTag: LibroxTagEntity) {
        bookxtagDao.insertLibroxTag(libroxTag)
    }

}