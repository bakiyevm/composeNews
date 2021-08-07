package kz.homecredit.landing.ui

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import kz.homecredit.core.base.IBaseViewModel
import kz.homecredit.core.navigator.Navigator
import kz.homecredit.landing.data.response.Article
import kz.homecredit.landing.domain.GetArticlesUseCase

class LandingViewModel @ViewModelInject constructor(
    val navigator: Navigator,
    private val getArticlesUseCase: GetArticlesUseCase,
) : IBaseViewModel() {

    private val _photo = MutableLiveData<String>()
    val photo: LiveData<String>
        get() = _photo

    fun getArticlePagination(): Flow<PagingData<Article>> {
        return getArticlesUseCase.invoke(Unit)
    }

    fun openImage(downloadUrl: String) {
        _photo.postValue(downloadUrl)
    }
}