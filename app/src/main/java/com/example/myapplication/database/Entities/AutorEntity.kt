package com.example.myapplication.database.Entities

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "autor_table")
data class AutorEntity(
    @PrimaryKey @ColumnInfo(name = "id_autor") val id_autor: Int,
    @ColumnInfo(name = "nombre_autor") val nombre_autor: String?
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun describeContents(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object CREATOR : Parcelable.Creator<AutorEntity> {
        override fun createFromParcel(parcel: Parcel): AutorEntity {
            return AutorEntity(parcel)
        }

        override fun newArray(size: Int): Array<AutorEntity?> {
            return arrayOfNulls(size)
        }
    }
}