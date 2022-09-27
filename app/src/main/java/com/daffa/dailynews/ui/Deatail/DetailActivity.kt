package com.daffa.dailynews.ui.Deatail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.daffa.dailynews.R
import com.daffa.dailynews.databinding.ActivityDetailBinding
import com.daffa.dailynews.network.response.HomeResponseItem

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val data = intent.getParcelableExtra<HomeResponseItem>(DETAIL_DATA) as HomeResponseItem
        Glide.with(this).load(data.thumb).into(binding.imgContent)
        binding.apply {
            tvTitle.text = data.title
            tvDate.text = data.time
            tvSource.text = data.author
            tvDetail.text = data.desc

        }
    }



    companion object {
        val DETAIL_DATA = "detail"
    }
}