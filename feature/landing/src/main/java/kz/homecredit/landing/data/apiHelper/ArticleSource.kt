package kz.homecredit.landing.data.apiHelper

import androidx.paging.PagingSource
import kz.homecredit.landing.data.response.Article
import javax.inject.Inject


class ArticleSource @Inject constructor(private val newsRepository: NewsRepository) :
    PagingSource<Int, Article>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val page = params.key ?: 1
            val pageSize = params.loadSize

            val newsResponse = newsRepository.getNews(Pair(page, pageSize))
            LoadResult.Page(
                data = newsResponse.articles,
                prevKey = if (page == 1) null else page - 1,
                nextKey = page.plus(1)
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}