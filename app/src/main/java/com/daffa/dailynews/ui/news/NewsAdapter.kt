package com.daffa.dailynews.ui.news

import android.view.LayoutInflater
import com.daffa.dailynews.network.response.NewsResponseItem
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.dailynews.databinding.FragmentHomeBinding
import com.daffa.dailynews.databinding.RowItemBinding
import com.daffa.dailynews.network.response.HomeResponseItem

class NewsAdapter(private val NewsList: List<NewsResponseItem>) :
    RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    class MyViewHolder(val binding: RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder (
        RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = NewsList[position]
        holder.binding.apply {
            tvCategory.text = data.tag
            tvTitle.text =data.title
            tvDate.text = data.time
            Glide.with(imgNews.context)
                .load(data.thumb)
                .into(imgNews)
        }
    }

    override fun getItemCount(): Int = NewsList.size
}