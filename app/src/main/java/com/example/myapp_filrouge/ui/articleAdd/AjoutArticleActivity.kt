package com.example.myapp_filrouge.ui.articleAdd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.myapp_filrouge.HomeActivity
import com.example.myapp_filrouge.databinding.ActivityMainBinding

class AjoutArticleActivity : AppCompatActivity() {
    lateinit var vm:AjoutArticleViewModel
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm = ViewModelProvider(this)[AjoutArticleViewModel::class.java]

        binding.vm = vm



        binding.btnSave.setOnClickListener{

            vm.addArticle()

            Intent(this, HomeActivity::class.java).also {
                it.putExtra("titre",vm.titre)
                it.putExtra("prix",vm.prix)
                startActivity(it)
            }


        }



    }
}