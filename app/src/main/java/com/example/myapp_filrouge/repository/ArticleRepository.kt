package com.example.myapp_filrouge.repository

import androidx.lifecycle.MutableLiveData
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.ArticleDao
import com.example.myapp_filrouge.dao.DaoFactory
import com.example.myapp_filrouge.dao.DaoType

class ArticleRepository {

    private val articleDAO: ArticleDao? = DaoFactory.createArticleDAO(DaoType.MEMORY)


    fun getArticle(id: Long): Article? {
        return articleDAO?.selectById(id)
        
    }

    fun addArticle(article:Article): Long? {

        return articleDAO?.addNewOne(article)
    }

    fun getAll():List<Article>?{
        return articleDAO?.selectAll()
    }
}
