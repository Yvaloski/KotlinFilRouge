package com.example.myapp_filrouge.ui.articleList

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
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

        binding.btnFav.setOnClickListener {
            vm.getArticleListFav().observe(viewLifecycleOwner) {
                displayArticles(it, view)
            }
        }

        //viewLifecycleOwner à utiliser dans les fragments
        vm.getArticleList().observe(viewLifecycleOwner) {
            displayArticles(it, view)
        }

    }

    private fun displayArticles(articles: List<Article>, view: View) {

        binding.rvArticleRecycler.adapter = ArticleAdapter(articles) {
            val direction =
                ListeArticlesFragmentDirections.listTodetail(it)
            Navigation.findNavController(view).navigate(direction)
        }
        binding.rvArticleRecycler.layoutManager = LinearLayoutManager(view.context)

    }
}