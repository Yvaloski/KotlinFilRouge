package com.example.myapp_filrouge.ui.articleList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation

import com.example.myapp_filrouge.databinding.FragmentListeArticlesBinding
import com.example.myapp_filrouge.ui.articleList.ListArticleViewModel
import com.example.myapp_filrouge.ui.articleList.ListeArticlesFragmentDirections

class ListeArticlesFragment : Fragment() {

    lateinit var binding: FragmentListeArticlesBinding
    lateinit var vm : ListArticleViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListeArticlesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm = ViewModelProvider(this)[ListArticleViewModel::class.java]

        //viewLifecycleOwner à utiliser dans les fragments
        vm.getArticleList().observe(viewLifecycleOwner){
            var titles = ""

            it.forEach {
                titles += it.titre + "\n"
            }.also {
                binding.tvTitre.text = titles
            }
        }

        binding.btnDetails.setOnClickListener {
            var article = vm.getRandomArticle()
            if(article != null){
                val direction =
                    ListeArticlesFragmentDirections.listTodetail(
                        article
                    )
                Navigation.findNavController(view).navigate(direction)
            }

        }

    }


}