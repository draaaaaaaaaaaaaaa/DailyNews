package com.daffa.dailynews.ui.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.dailynews.network.api.ApiConfig
import com.daffa.dailynews.network.response.NewsResponseItem
import com.daffa.dailynews.network.response.ReviewResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ReviewViewModel() : ViewModel() {

    private val listrev = MutableLiveData<List<ReviewResponseItem>>()

    fun getRevModel(){
        ApiConfig().getApiService().getRev().enqueue(object : Callback<List<ReviewResponseItem>> {
            override fun onResponse(
                call: Call<List<ReviewResponseItem>>,
                response: Response<List<ReviewResponseItem>>
            ) {
                listrev.value = response.body()
            }

            override fun onFailure(call: Call<List<ReviewResponseItem>>, t: Throwable) {

            }
        })
    }

    fun getRevNews() : LiveData<List<ReviewResponseItem>> = listrev
}