package com.daffa.dailynews.ui.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.daffa.dailynews.databinding.RowItemBinding
import com.daffa.dailynews.network.response.ReviewResponseItem

class RevAdapter(private val RevList: List<ReviewResponseItem>) :
    RecyclerView.Adapter<RevAdapter.wViewHolder>() {

    class wViewHolder(val binding : RowItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = wViewHolder (
        RowItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
    )

    override fun onBindViewHolder(holder: wViewHolder, position: Int) {
       val data = RevList[position]
        holder.binding.apply {
            tvTitle.text = data.title
            tvDate.text = data.time
            tvCategory.text = data.tag
            Glide.with(imgNews.context)
                .load(data.thumb)
                .into(imgNews)
        }

    }

    override fun getItemCount(): Int = RevList.size
}