package kz.homecredit.landing.data.apiHelper

import kz.homecredit.core.base.IBaseRepository
import kz.homecredit.landing.data.response.NewsResponse


interface NewsRepository : IBaseRepository {

    suspend fun getNews(input: Pair<Int, Int>): NewsResponse

}