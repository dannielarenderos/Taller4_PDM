package com.example.myapplication.database.DAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.database.Entities.LibroxAutorEntity


@Dao
interface LibroxAutorDAO {


    @Insert
    suspend fun insertarLibroxAutor(LibroxAutor:LibroxAutorEntity)

    @Query("SELECT * FROM LibroxAutor")
    fun getAllLibroxAutor():LiveData<List<LibroxAutorEntity>>

}
