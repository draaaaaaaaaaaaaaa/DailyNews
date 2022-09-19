package com.daffa.dailynews.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.dailynews.network.api.ApiConfig
import com.daffa.dailynews.network.response.NewsResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel () : ViewModel() {

    private val listNews = MutableLiveData<List<NewsResponseItem>>()

    fun getNewsModel(){
        ApiConfig().getApiService().getNews().enqueue(object : Callback<List<NewsResponseItem>> {
            override fun onResponse(
                call: Call<List<NewsResponseItem>>,
                response: Response<List<NewsResponseItem>>
            ) {
                listNews.value = response.body()
            }

            override fun onFailure(call: Call<List<NewsResponseItem>>, t: Throwable) {

            }
        })
    }

    fun getListNews() : LiveData<List<NewsResponseItem>> = listNews
}