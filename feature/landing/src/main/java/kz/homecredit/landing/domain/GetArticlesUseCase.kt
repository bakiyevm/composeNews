package kz.homecredit.landing.domain

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kz.homecredit.core.base.IBaseUseCase
import kz.homecredit.landing.data.apiHelper.ArticleSource
import kz.homecredit.landing.data.response.Article
import javax.inject.Inject

class GetArticlesUseCase @Inject constructor(private val articleSource: ArticleSource) :
    IBaseUseCase<Unit, PagingData<Article>> {

    override fun invoke(input: Unit): Flow<PagingData<Article>> {
        return Pager(PagingConfig(pageSize = 15)) {
            articleSource
        }.flow
    }

}