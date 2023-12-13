package com.example.myapp_filrouge.ui.articleView

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.ArticleDao
import com.example.myapp_filrouge.db.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class DetailArticleViewModel(private val articleDao: ArticleDao) : ViewModel() {
    var fav = MutableLiveData<Boolean>(false)


    fun addArticleTofav(article: Article) {

        viewModelScope.launch (Dispatchers.IO){
            articleDao.addNewOne(article)
        }

    }

    fun deleteArticleFav(article: Article){
        viewModelScope.launch(Dispatchers.IO) {
            articleDao.delete(article)
        }
    }

    fun getArticle(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            articleDao.selectById(id)
        }
    }

    fun checkArticle(id:Long){
        viewModelScope.launch(Dispatchers.IO) {

            val article = articleDao.selectById(id)

            if (article != null){
                fav.postValue(true)

            }
        }

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

                return DetailArticleViewModel(
                    AppDatabase.getInstance(application.applicationContext).articleDAO()
                ) as T
            }
        }
    }


}