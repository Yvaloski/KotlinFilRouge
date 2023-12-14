package com.example.myapp_filrouge.ui.articleList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.ArticleDao
import com.example.myapp_filrouge.db.AppDatabase
import com.example.myapp_filrouge.repository.ArticleRepository
import com.example.myapp_filrouge.ui.articleView.DetailArticleViewModel
import com.example.myapp_filrouge.utils.ProductService
import com.example.myapp_filrouge.utils.ProductService.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListArticleViewModel(private val articleDao: ArticleDao):ViewModel() {

    private var articleRepository: ArticleRepository = ArticleRepository()

    fun getArticleListFav(): MutableLiveData<List<Article>> {
        viewModelScope.launch(Dispatchers.IO) {
            articles.postValue(articleDao.selectAll())
        }
        return articles
    }


    var articles = MutableLiveData<List<Article>>()

     fun getArticleList(): MutableLiveData<List<Article>> {

        viewModelScope.launch {
            articles.value = ProductApi.retrofitService.getProducts()
        }

        return articles


    }



    companion object {

        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])

                return ListArticleViewModel(
                    AppDatabase.getInstance(application.applicationContext).articleDAO()
                ) as T
            }
        }
    }


}