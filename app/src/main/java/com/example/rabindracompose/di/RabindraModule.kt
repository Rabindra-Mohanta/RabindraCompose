package com.example.rabindracompose.di
import com.example.rabindracompose.data.remote.Api
import com.example.rabindracompose.data.repository.PhotoRepositoryImpl
import com.example.rabindracompose.domain.repository.PhotoRepository
import com.example.rabindracompose.domain.useCases.home.GetPhotos
import com.example.rabindracompose.domain.useCases.home.PhotoUseCases
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

    @Provides
    @Singleton
    fun providePhotoRepository(api: Api):PhotoRepository = PhotoRepositoryImpl(api)

    @Provides
    @Singleton
    fun providePhotoUseCases(photoRepository: PhotoRepository):PhotoUseCases
    {
        return PhotoUseCases(getPhotos = GetPhotos(photoRepository))
    }

//    @Provides
//    @Singleton
//    fun providedNewsUseCases(newsRepository: NewsRepository,newsDao: NewsDao): NewsUseCases {
//        return NewsUseCases(getNews = GetNews(newsRepository), searchNews = SearchNews(newsRepository), upsertArticle = UpsertArticle(newsDao), deleteArticle = DeleteArticle(newsDao), selectArticles = SelectArticles(newsDao))
//    }
}
