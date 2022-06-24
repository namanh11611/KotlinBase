package com.namanh.kotlinbase.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.namanh.kotlinbase.R
import com.namanh.kotlinbase.data.model.News
import com.namanh.kotlinbase.databinding.ItemNewsBinding
import com.namanh.kotlinbase.helper.GlideHelper
import com.namanh.kotlinbase.utils.AppUtils

class NewsAdapter(var dataSet: List<News>) : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root),
        View.OnClickListener {

        private lateinit var mNews: News

        init {
            binding.clNews.setOnClickListener(this)
        }

        fun bind(news: News) {
            mNews = news
            binding.txtTitle.text = news.title
            binding.txtDescription.text = news.description
            binding.txtAuthor.text = news.author
            binding.txtTime.text = news.publishedAt
            GlideHelper.loadImage(binding.root.context, binding.imgNews, news.urlToImage)
        }

        override fun onClick(v: View?) {
            val bundle = bundleOf(AppUtils.NAV_NEWS_ITEM to Gson().toJson(mNews))
            binding.root.findNavController()
                .navigate(R.id.action_newsListFragment_to_newsDetailFragment, bundle)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
    }

    override fun getItemCount() = dataSet.size
}