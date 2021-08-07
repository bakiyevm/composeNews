package kz.homecredit.landing.data.response

import com.google.gson.annotations.SerializedName

data class Article (
    @SerializedName("author")
    val author: String = "",
    @SerializedName("title")
    val title: String = "",
    @SerializedName("urlToImage")
    val downloadUrl: String = ""
)