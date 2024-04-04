package com.example.rabindracompose.di
import com.example.rabindracompose.data.remote.Api
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RabindraModule {
    @Provides
    @Singleton
    fun getRetroFit():Api = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com").addConverterFactory(GsonConverterFactory.create()).build().create(Api::class.java)

}
