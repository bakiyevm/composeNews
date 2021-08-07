package kz.homecredit.landing.data.apiHelper

import kz.homecredit.landing.data.response.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiService {

    @GET("everything")
    suspend fun getNews(
        @Query("q") keyword: String? = "Apple",
        @Query("page") pageNumber: Int,
        @Query("pageSize") pageSize: Int = 15
    ): NewsResponse

}
