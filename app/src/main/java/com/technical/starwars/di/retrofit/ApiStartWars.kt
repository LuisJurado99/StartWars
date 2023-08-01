package com.technical.starwars.di.retrofit

import com.technical.starwars.data.CharacterRepository
import com.technical.starwars.data.retrofit.RetrofitCharactersPetitions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiStartWars {


    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Singleton
    @Provides
    fun providesOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(httpLoggingInterceptor).build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().apply {
        baseUrl(URL_START_WARS)
        addConverterFactory(GsonConverterFactory.create())
        client(okHttpClient)
    }.build()

    @Singleton
    @Provides
    fun provideRetrofitCharactersPetitions(retrofit: Retrofit): RetrofitCharactersPetitions {
        return retrofit.create(RetrofitCharactersPetitions::class.java)
    }
    
    @Singleton
    @Provides
    fun providesCharacterRepository(retrofitCharactersPetitions: RetrofitCharactersPetitions) =
        CharacterRepository(retrofitCharactersPetitions)

    companion object {
        private val URL_START_WARS: String = "https://rickandmortyapi.com/api/"
    }
}