package com.example.myapp_filrouge.fragments

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.myapp_filrouge.R
import com.example.myapp_filrouge.databinding.FragmentDetailArticleBinding
import com.example.myapp_filrouge.databinding.FragmentListeArticlesBinding

class DetailArticleFragment : Fragment() {

    val args: DetailArticleFragmentArgs by navArgs()

    lateinit var binding: FragmentDetailArticleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailArticleBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val article = args.article
        binding.article= article

        binding.tvTitreArticle.setOnClickListener{

            // explicit INtent

            /*Intent(Intent.ACTION_WEB_SEARCH).also {

                it.putExtra(SearchManager.QUERY, "eni-shop" + binding.article.titre)
                startActivity(it)
            }*/

            Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/search?q=eni-shop" + article.titre )).also {
                startActivity(it)
            }
        }

    }

}