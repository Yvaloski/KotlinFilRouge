package com.example.myapp_filrouge.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapp_filrouge.R
import com.example.myapp_filrouge.databinding.FragmentListeArticlesBinding
import com.example.myapp_filrouge.repository.ArticleRepository


class ListeArticlesFragment : Fragment() {

    lateinit var binding: FragmentListeArticlesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentListeArticlesBinding.inflate(layoutInflater, container, false)
        return binding.root
     }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val articles = ArticleRepository().getAll()
        var title = ""

        articles?.forEach {
            title += it.titre + "\n"
        }.also {
            binding.tvTitre.text = title
        }

        binding.btnDetails.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.listTodetail)

        }

    }
}