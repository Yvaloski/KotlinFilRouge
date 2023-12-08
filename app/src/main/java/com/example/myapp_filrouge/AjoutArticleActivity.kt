package com.example.myapp_filrouge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.memory.ArticleDaoMemoryImpl
import com.example.myapp_filrouge.databinding.ActivityMainBinding
import com.example.myapp_filrouge.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.util.Date
import java.util.zip.Inflater

private const val TAG = "MainActivity"
class AjoutArticleActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.article = Article(0, "", "", 0.0,"", Date())

        binding.btnSave.setOnClickListener{

            Log.i(TAG, binding.article.toString())
            ArticleRepository().addArticle(binding.article!!)

            Intent(this, HomeActivity::class.java).also {
                it.putExtra("title",binding.article?.titre)
                it.putExtra("price",binding.article?.prix.toString())
                startActivity(it)

            }

        }



    }
}