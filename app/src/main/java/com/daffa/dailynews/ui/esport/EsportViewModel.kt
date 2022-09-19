package com.daffa.dailynews.ui.esport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.daffa.dailynews.network.api.ApiConfig
import com.daffa.dailynews.network.response.EsportResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EsportViewModel() : ViewModel() {

    private val listEsport = MutableLiveData<List<EsportResponseItem>>()

    fun getEsportModel(){
        ApiConfig().getApiService().getEsport().enqueue(object :
            Callback<List<EsportResponseItem>> {
            override fun onResponse(
                call: Call<List<EsportResponseItem>>,
                response: Response<List<EsportResponseItem>>
            ) {
                listEsport.value =response.body()
            }

            override fun onFailure(call: Call<List<EsportResponseItem>>, t: Throwable) {

            }
        })
    }

    fun getListEsport() : LiveData<List<EsportResponseItem>> = listEsport
}




