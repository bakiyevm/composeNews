package kz.homecredit.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import kz.homecredit.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named


@Module
@InstallIn(ActivityComponent::class)
class NetworkModule {

    companion object {
        const val BASE_URL = "baseUrl"
        const val API_KEY = "apiKey"
    }

    @Provides
    fun provideQueryInterceptor(@Named(API_KEY) apiKey: String): Interceptor {
        return object : Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response {
                return with(chain.request()) {
                    val url = url.newBuilder()
                        .addQueryParameter(API_KEY, apiKey)
                        .build()
                    val request = newBuilder()
                        .url(url = url)
                        .build()

                    chain.proceed(request = request)
                }
            }
        }
    }

    @Provides
    fun provideOkHttpClient(queryInterceptor: Interceptor): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .addInterceptor(queryInterceptor)

        if (BuildConfig.DEBUG) {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, @Named(BASE_URL) baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .build()
    }

}
