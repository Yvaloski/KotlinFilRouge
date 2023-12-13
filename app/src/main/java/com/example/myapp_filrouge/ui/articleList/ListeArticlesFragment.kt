package com.example.myapp_filrouge.ui.articleList

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapp_filrouge.adapters.ArticleAdapter
import com.example.myapp_filrouge.bo.Article

import com.example.myapp_filrouge.databinding.FragmentListeArticlesBinding
import com.example.myapp_filrouge.ui.articleView.DetailArticleFragment

class ListeArticlesFragment : Fragment() {

    lateinit var binding: FragmentListeArticlesBinding
    val vm: ListArticleViewModel by viewModels { ListArticleViewModel.Factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListeArticlesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recycler = binding.rvArticleRecycler

        val articleAdapter = ArticleAdapter(vm.articles) { name ->
            val intent = Intent(view.context, DetailArticleFragment::class.java)
            intent.putExtra("name", name)
            startActivity(intent)
        }
        recycler.adapter = articleAdapter
        recycler.layoutManager = LinearLayoutManager(view.context)



        vm.getArticleList().observe(viewLifecycleOwner) {
            displayArticle(it)
        }


        binding.btnFav.setOnClickListener {
            vm.getArticleListFav().observe(viewLifecycleOwner) {
                displayArticle(it)
                articleAdapter.notifyDataSetChanged()

            }
        }

    }

    private fun displayArticle(articles: List<Article>) {
        var titles = ""
        articles.forEach {
            titles += it.titre + "\n"
        }.also {
            // You can update UI or perform any other operation with the titles

        }
    }
}