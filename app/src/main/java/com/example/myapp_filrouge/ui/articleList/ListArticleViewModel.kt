package com.example.myapp_filrouge.ui.articleList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.repository.ArticleRepository

class ListArticleViewModel:ViewModel() {

    private var articleRepository: ArticleRepository = ArticleRepository()

    var articles = MutableLiveData<List<Article>>()

    fun getArticleList(): MutableLiveData<List<Article>> {

        articles.value = articleRepository.getAll()

        return articles

    }

    fun getRandomArticle():Article{


        return articles.value?.random()!!

    }



}