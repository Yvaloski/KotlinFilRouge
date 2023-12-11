package com.example.myapp_filrouge.ui.articleAdd

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.repository.ArticleRepository
import com.example.myapp_filrouge.utils.DateConverter
import java.text.SimpleDateFormat
import java.util.Date

class AjoutArticleViewModel : ViewModel() {


    var titre: String = ""
    var description: String = ""
    var prix: Double = 0.0
    var dateSortie: String = ""

    private var articleRepo = ArticleRepository()

    fun addArticle() {

        val article = Article(0, titre, description, prix, "", DateConverter.stringToSimpleDate(dateSortie))


       articleRepo.addArticle(article)

    }

}