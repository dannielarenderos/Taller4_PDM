package com.example.myapplication.database.Entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(
    tableName = "LibroxTag",
    foreignKeys = [
        ForeignKey(entity = TagEntity::class, parentColumns = ["id_tag"], childColumns = ["fk_Tag"]),
        ForeignKey(entity = LibroEntity::class, parentColumns = ["id_libro"], childColumns = ["fk_Libro"])
    ]
)
data class LibroxTagEntity (
    @PrimaryKey @ColumnInfo(name = "id_LibroxTag") val id_LibroxTag: Int,
    @ColumnInfo(name = "fk_Tag") val Fk_Tag: Int,
    @ColumnInfo(name = "fk_Libro") val Fk_Libro: Int
)
