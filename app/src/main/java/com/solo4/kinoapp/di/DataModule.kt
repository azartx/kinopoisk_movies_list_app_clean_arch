package com.solo4.kinoapp.di

import com.solo4.kinoapp.common.utils.API_BASE_URL
import com.solo4.kinoapp.data.datasource.MoviesApi
import com.solo4.kinoapp.data.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import hu.akarnokd.rxjava3.retrofit.RxJava3CallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
object DataModule {
    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(API_BASE_URL)
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptors: List<@JvmSuppressWildcards Interceptor>
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }


    @Singleton
    @Provides
    fun provideInterceptors(): List<Interceptor> {
        return buildList {
            add(
                HttpLoggingInterceptor().apply {
                    level = /*if (BuildConfig.DEBUG) {*/
                        HttpLoggingInterceptor.Level.BODY
                    /*} else {
                        HttpLoggingInterceptor.Level.NONE
                    }*/
                }
            )
            add(AuthInterceptor())
        }
    }
}
