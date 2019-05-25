package com.example.myapplication.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "LibroxAutor",
    foreignKeys = [
        ForeignKey(entity = AutorEntity::class, parentColumns = ["id_autor"], childColumns = ["fk_Autor"]),
        ForeignKey(entity = LibroEntity::class, parentColumns = ["id_libro"], childColumns = ["fk_Libro"])
    ]
)
data class LibroxAutorEntity(

    @PrimaryKey @ColumnInfo(name = "id_LibroxAutor") val id_LibroxAutor: Int,
    @ColumnInfo(name = "fk_Autor") val Fk_Autor: Int,
    @ColumnInfo(name = "fk_Libro") val Fk_Libro: Int
)