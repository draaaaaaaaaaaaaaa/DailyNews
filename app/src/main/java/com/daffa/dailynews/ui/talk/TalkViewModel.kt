package com.daffa.dailynews.ui.talk

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.dailynews.network.api.ApiConfig
import com.daffa.dailynews.network.response.NewsResponseItem
import com.daffa.dailynews.network.response.TalkResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TalkViewModel() : ViewModel() {

    private val listTalk = MutableLiveData<List<TalkResponseItem>>()

    fun getTalkModel(){
        ApiConfig().getApiService().getTalk().enqueue(object : Callback<List<TalkResponseItem>> {
            override fun onResponse(
                call: Call<List<TalkResponseItem>>,
                response: Response<List<TalkResponseItem>>
            ) {
                listTalk.value = response.body()
            }

            override fun onFailure(call: Call<List<TalkResponseItem>>, t: Throwable) {

            }

        })
    }

    fun getTalkNews() : LiveData<List<TalkResponseItem>> = listTalk
}