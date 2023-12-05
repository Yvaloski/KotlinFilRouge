package com.example.myapp_filrouge.dao

import com.example.myapp_filrouge.dao.memory.ArticleDaoMemoryImpl
import com.example.myapp_filrouge.dao.network.ArticleDaoNetworkImpl

abstract class DaoFactory {
    companion object {
        fun createArticleDAO(type: DaoType): ArticleDao? {
            val dao:ArticleDao? = when (type) {
                DaoType.MEMORY -> ArticleDaoMemoryImpl()
                DaoType.NETWORK -> ArticleDaoNetworkImpl()

            }
            return  dao
        }
    }
}