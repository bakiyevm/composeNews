package kz.homecredit.landing.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kz.homecredit.landing.data.apiHelper.INewsRepository
import kz.homecredit.landing.data.apiHelper.NewsRepository

@Module
@InstallIn(ActivityComponent::class)
class RepositoryModule {

    @Provides
    fun provideNewsRepository(repository: INewsRepository): NewsRepository {
        return repository
    }
}