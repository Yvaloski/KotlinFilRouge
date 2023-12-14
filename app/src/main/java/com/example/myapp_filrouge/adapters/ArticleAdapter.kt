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
import com.example.myapp_filrouge.utils.ProductService
import com.squareup.picasso.Picasso

class ArticleAdapter(val articleList: List<Article>, val listener: (article: Article) -> Unit) :
    Adapter<ArticleAdapter.ArticleVH>() {

    class ArticleVH(val binding: ItemArticleLineBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleVH {
        val binding = ItemArticleLineBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ArticleVH(binding)
    }

    override fun getItemCount(): Int {
        return articleList.size
    }

    override fun onBindViewHolder(holder: ArticleVH, position: Int) {
        holder.binding.article = articleList[position]
        holder.itemView.setOnClickListener {
            listener.invoke(articleList[position])
        }
    }

}