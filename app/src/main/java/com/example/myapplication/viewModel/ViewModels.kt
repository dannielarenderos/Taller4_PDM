package com.example.myapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.database.AppDatabase
import com.example.myapplication.database.Entities.LibroEntity
import com.example.myapplication.repository.AutorRepository
import com.example.myapplication.repository.LibroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModels (aplicacion:Application) : AndroidViewModel(aplicacion) {

    private val repositorioLibro : LibroRepository
    val allLibros: LiveData<List<LibroEntity>>


    init {
        val LibrosDao = AppDatabase.getDatabase(aplicacion, viewModelScope).libroDao()
        val LibroXautorDao = AppDatabase.getDatabase(aplicacion, viewModelScope).libroxautorDao()
        val LibroxTagDao = AppDatabase.getDatabase(aplicacion, viewModelScope).libroxtagDao()
        repositorioLibro = LibroRepository(LibrosDao,LibroXautorDao,LibroxTagDao )
        allLibros = repositorioLibro.allBooks

    }

    fun insertLibro(libro: LibroEntity) = viewModelScope.launch(Dispatchers.IO) {
        repositorioLibro.insertBook(libro)
    }


}