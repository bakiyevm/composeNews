package kz.homecredit.landing.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kz.homecredit.landing.data.apiHelper.NewsApiService
import retrofit2.Retrofit

@Module
@InstallIn(ActivityComponent::class)
class ServiceModule {

    @Provides
    fun provideNewsApiService(retrofit: Retrofit): NewsApiService {
        return retrofit.create(NewsApiService::class.java)
    }
}