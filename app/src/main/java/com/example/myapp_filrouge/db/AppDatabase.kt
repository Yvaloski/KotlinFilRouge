package com.example.myapp_filrouge.db


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.ArticleDao
import com.example.myapp_filrouge.utils.Converters

@Database(entities = [Article::class], version = 1)
@TypeConverters(Converters::class)

abstract class AppDatabase : RoomDatabase() {

    //Liste des DAOS

    abstract fun articleDAO(): ArticleDao

    companion object {

        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            var instance = INSTANCE
            if (instance == null) {

                instance = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "Articles"
                ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

                INSTANCE = instance
            }
            return instance
        }

    }

}