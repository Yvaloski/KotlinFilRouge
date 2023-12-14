package com.example.myapp_filrouge.ui.articleView

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.myapp_filrouge.databinding.FragmentDetailArticleBinding
import com.example.myapp_filrouge.utils.ProductService
import com.squareup.picasso.Picasso

const val TAG = "DetailsArticleFr"

class DetailArticleFragment : Fragment() {

    val args: DetailArticleFragmentArgs by navArgs()
    val vm: DetailArticleViewModel by viewModels { DetailArticleViewModel.Factory }

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


        binding.article = article
        binding.vm = vm

        vm.checkArticle(article.id)
        binding.lifecycleOwner=this

        Picasso.get().load(article.urlImage).into(binding.imageView)


        var image = binding.imageView
        binding.ckFavoris.setOnClickListener {


            if (binding.ckFavoris.isChecked){

                vm.addArticleTofav(article)
                Toast.makeText(context,"Article ajouté !",Toast.LENGTH_LONG).show()


            }else{

                vm.deleteArticleFav(article)
                Toast.makeText(context,"Article Supprimé !",Toast.LENGTH_LONG).show()
            }

        }


        binding.tvTitreArticle.setOnClickListener {

            // explicit Intent

            /*Intent(Intent.ACTION_WEB_SEARCH).also {

                it.putExtra(SearchManager.QUERY, "eni-shop" + binding.article.titre)
                startActivity(it)
            }*/
            // implicit Intent

            Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://google.com/search?q=eni-shop" + article.titre)
            ).also {
                startActivity(it)
            }
        }

    }

}