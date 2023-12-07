package com.example.myapp_filrouge.dao.memory

import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.ArticleDao
import java.util.Date

class ArticleDaoMemoryImpl : ArticleDao {

    companion object{
    private var articlesInMemory: MutableList<Article> = mutableListOf(
        Article(
            1,
            "Smartphone dernier cri",
            "Un smartphone révolutionnaire avec des fonctionnalités incroyables.",
            799.99,
            "https://example.com/smartphone.jpg",
            Date()
        ),
        Article(
            2,
            "Montre intelligente",
            "Une montre connectée qui suit votre activité et surveille votre santé.",
            199.99,
            "https://example.com/smartwatch.jpg",
            Date()
        ),
        Article(
            3,
            "Casque audio spatial",
            "Un casque audio qui vous transporte dans un monde sonore immersif.",
            149.99,
            "https://example.com/headphones.jpg",
            Date()
        ),
        Article(
            4,
            "",
            "",
            0.0,
            "",
            Date()
        )


    )
    }
    override fun selectById(id: Long): Article {

        var article: Article?
        article = articlesInMemory.first(){
            it.id == id
        }
        return article
    }

    override fun addNewOne(article: Article): Long {
        article.id = articlesInMemory.size +1L

        articlesInMemory.add(article)

        // Retourner le nouvel ID
        return article.id
    }

    override fun selectAll(): List<Article> {

        return articlesInMemory
    }


}