package kz.homecredit.landing.data.apiHelper

import kz.homecredit.landing.data.response.NewsResponse
import javax.inject.Inject

class INewsRepository @Inject constructor(private val apiService: NewsApiService
) : NewsRepository {

    override suspend fun getNews(input: Pair<Int, Int>): NewsResponse {
        return apiService.getNews(pageNumber = input.first, pageSize = input.second)
    }
}
