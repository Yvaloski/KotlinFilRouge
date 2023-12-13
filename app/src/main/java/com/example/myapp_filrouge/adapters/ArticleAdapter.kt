package com.example.myapp_filrouge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.myapp_filrouge.bo.Article
import com.example.myapp_filrouge.databinding.ItemArticleLineBinding
import com.example.myapp_filrouge.ui.articleList.ListeArticlesFragmentDirections

class ArticleAdapter(val articleList: MutableLiveData<List<Article>>, val listener: (name :String)->Unit):
    Adapter<ArticleAdapter.ArticleVH>() {
    class ArticleVH (val binding:ItemArticleLineBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = ItemArticleLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false)

        return ArticleVH(binding)
    }

    override fun getItemCount() =articleList.value?.size!!

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        val article = articleList.value?.get(position)
        if (article != null) {
            holder.binding.article = article
            holder.itemView.setOnClickListener {
                val action = ListeArticlesFragmentDirections.listTodetail(article)
                holder.itemView.findNavController().navigate(action)
            }
        }
    }


}