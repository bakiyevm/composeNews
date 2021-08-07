package kz.homecredit.news.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kz.homecredit.core.di.NetworkModule.Companion.API_KEY
import kz.homecredit.core.di.NetworkModule.Companion.BASE_URL
import javax.inject.Named

@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    @Provides
    @Named(BASE_URL)
    fun provideBaseUrl(): String = "https://newsapi.org/v2/"

    @Provides
    @Named(API_KEY)
    fun provideApiKey(): String = "e65ee0938a2a43ebb15923b48faed18d"

}