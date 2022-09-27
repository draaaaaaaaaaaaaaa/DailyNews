package com.daffa.dailynews.network.api

import com.daffa.dailynews.network.response.*
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("api/games")
    fun getHome() : Call<List<HomeResponseItem>>

    @GET("api/games/e-sport")
    fun getEsport(): Call<List<EsportResponseItem>>

    @GET("api/games/news")
    fun getNews() : Call<List<NewsResponseItem>>

    @GET("api/games/lazy-talk")
    fun getTalk() : Call<List<TalkResponseItem>>

    @GET("api/games/review")
    fun getRev() : Call<List<ReviewResponseItem>>
}