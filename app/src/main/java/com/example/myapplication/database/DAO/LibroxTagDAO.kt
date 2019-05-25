package com.example.myapplication.database.DAO

import androidx.room.Dao
import androidx.room.Insert
import com.example.myapplication.database.Entities.LibroxTagEntity

@Dao
interface LibroxTagDAO {

@Insert
suspend fun insertLibroxTag(LibroxTag:LibroxTagEntity)


}