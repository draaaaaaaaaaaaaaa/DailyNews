package com.daffa.dailynews.network.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ReviewResponse(

	@field:SerializedName("ReviewResponse")
	val reviewResponse: List<ReviewResponseItem?>? = null
) : Parcelable

@Parcelize
data class ReviewResponseItem(

	@field:SerializedName("thumb")
	val thumb: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("tag")
	val tag: String? = null,

	@field:SerializedName("time")
	val time: String? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("key")
	val key: String? = null,

	@field:SerializedName("desc")
	val desc: String? = null
) : Parcelable
