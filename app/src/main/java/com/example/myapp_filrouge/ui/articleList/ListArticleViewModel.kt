package com.example.myapp_filrouge.ui.articleList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.repository.ArticleRepository

class ListArticleViewModel:ViewModel() {


    val listArticle = MutableLiveData<Article>()

    fun getArticleList(): List<Article>? {
        return ArticleRepository().getAll()
    }


    fun getRandomArticle(){
      /*  articleId = (listArticle.valu)
        var randomArticle = ArticleRepository().getArticle()*/
    }

}