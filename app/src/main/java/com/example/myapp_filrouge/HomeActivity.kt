package com.example.myapp_filrouge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.databinding.ActivityHomeBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<FloatingActionButton>(R.id.fab_add_article).setOnClickListener {

            Intent(this, AjoutArticleActivity::class.java).also {
                startActivity(it)
            }

        }

        val title = intent.getStringExtra("title")
        val price = intent.getStringExtra("price")


        if (title != null && price != null){
            Snackbar.make(
                findViewById(R.id.homelayout),
                "Vous venez de créer $title vendu a $price €",
                Snackbar.LENGTH_LONG
            ).show()
        }




    }


}