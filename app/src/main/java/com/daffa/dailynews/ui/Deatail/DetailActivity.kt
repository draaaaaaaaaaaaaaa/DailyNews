package com.daffa.dailynews.ui.Deatail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.daffa.dailynews.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
    }



    companion object {
        val DETAIL_DATA = "detail"
    }
}