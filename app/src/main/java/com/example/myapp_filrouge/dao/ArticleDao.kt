package com.example.myapp_filrouge.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapp_filrouge.bo.Article
@Dao
interface ArticleDao {

    @Query("SELECT * FROM Article WHERE id = :id")
    fun selectById(id: Long): Article?

    @Insert
    fun addNewOne(article: Article): Long

    @Query("SELECT * FROM Article")
    fun selectAll():List<Article>

    @Delete
    fun delete(article: Article)



}