package kz.homecredit.landing.data.response


import com.google.gson.annotations.SerializedName

data class NewsResponse(@SerializedName("articles")
                         val articles: List<Article>)


