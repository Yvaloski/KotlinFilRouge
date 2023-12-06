package com.example.myapp_filrouge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.dao.DaoFactory
import com.example.myapp_filrouge.dao.memory.ArticleDaoMemoryImpl
import com.example.myapp_filrouge.databinding.ActivityMainBinding
import com.example.myapp_filrouge.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import java.util.Date
import java.util.zip.Inflater

private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.article = ArticleRepository().getArticle(4)

        binding.btnSave.setOnClickListener{

            Snackbar.make(it, "Vous venez de créer ${binding.article?.titre} vendu a ${binding.article?.prix} €", Snackbar.LENGTH_LONG).show()


        }



    }
}