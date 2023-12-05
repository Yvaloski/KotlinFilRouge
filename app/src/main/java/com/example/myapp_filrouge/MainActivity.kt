package com.example.myapp_filrouge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.repository.ArticleRepository
import java.util.Date

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val article = ArticleRepository().getArticle(1)
        val article = Article(0,"Barrette RAM", "4 x 16Go ram", 25.0,
            " ", Date()
        )
        val id = ArticleRepository().addArticle(article)
        val article2 = ArticleRepository().getArticle(id!!)

        Log.i(TAG, "Id Article généré: $id ")
        Log.i(TAG, "Article généré: $article2 ")


    }
}