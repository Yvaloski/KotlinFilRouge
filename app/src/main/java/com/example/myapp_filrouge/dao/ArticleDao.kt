package com.example.myapp_filrouge.dao

import com.example.myapp_filrouge.bo.Article

interface ArticleDao {
    fun selectById(id: Long): Article?

    fun addNewOne(article: Article): Long

    fun selectAll():List<Article>




}