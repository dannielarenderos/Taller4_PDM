package com.example.myapplication.database

import android.content.Context
import androidx.room.*
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myapplication.database.DAO.*
import com.example.myapplication.database.Entities.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.security.AccessControlContext

@Database(
    entities = [LibroEntity::class, AutorEntity::class, TagEntity::class,
        LibroxAutorEntity::class, LibroxTagEntity::class], version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun libroDao(): LibroDAO
    abstract fun autorDao(): AutorDAO
    abstract fun tagDao(): TagDAO
    abstract fun libroxautorDao(): LibroxAutorDAO
    abstract fun libroxtagDao(): LibroxTagDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "Book_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(DatabseCall(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }


        private class DatabseCall(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)

                INSTANCE?.let { appDatabase ->
                    scope.launch(Dispatchers.IO) {
                        LlenarDB(
                            appDatabase.libroDao(),
                            appDatabase.autorDao(),
                            appDatabase.tagDao(),
                            appDatabase.libroxautorDao(),
                            appDatabase.libroxtagDao()
                        )
                    }
                }
            }
        }

        suspend fun LlenarDB(
            libroDAO: LibroDAO,
            autorDAO: AutorDAO,
            tagDAO: TagDAO,
            libroxautorDao: LibroxAutorDAO,
            libroxtagDao: LibroxTagDAO
        ) {

            var autor = AutorEntity(1, "Danniela Renderos")
            autorDAO.insertAutor(autor)
            autor = AutorEntity(2, "Fatima Renderos")
            autorDAO.insertAutor(autor)

            var tag = TagEntity(1, "Romance")
            tagDAO.insert_tag(tag)
            tag = TagEntity(2, "Ficcion")
            tagDAO.insert_tag(tag)


            var libro = LibroEntity(
                1, "La biblia", "https://porfirioflores.org/wp-content/uploads/2018/01/biblia.jpg", "La casa",
                123, "Historia de Dios", 1, 1
            )
            libroDAO.insertLibro(libro)

            libro = LibroEntity(
                2, "Sherlock Holmes", "https://dg9aaz8jl1ktt.cloudfront.net/the_files/46589/std.jpg?1452597915", "La casa",
                1255, "Historia de detectives", 2, 1
            )
            libroDAO.insertLibro(libro)

            libro = LibroEntity(
                3, "GOT", "https://www.thomann.de/pics/bdb/439871/13137706_800.jpg", "La casa",
                1255, "Historia de guerra y dragones", 2, 0
            )
            libroDAO.insertLibro(libro)


            var LibroxAutor = LibroxAutorEntity(
                1, 1, 2
            )
            libroxautorDao.insertarLibroxAutor(LibroxAutor)


            LibroxAutor = LibroxAutorEntity(
                2, 2, 3
            )
            libroxautorDao.insertarLibroxAutor(LibroxAutor)

            LibroxAutor = LibroxAutorEntity(
                3, 2, 2
            )
            libroxautorDao.insertarLibroxAutor(LibroxAutor)
        }
    }


}