package com.example.rabindracompose.di
import android.content.Context
import androidx.room.Room
import com.example.rabindracompose.data.local.RabindraDataBase
import com.example.rabindracompose.data.remote.Api
import com.example.rabindracompose.data.repository.PhotoRepositoryImpl
import com.example.rabindracompose.data.utils.Constants.DB_NAME
import com.example.rabindracompose.domain.repository.PhotoRepository
import com.example.rabindracompose.domain.useCases.home.GetPhotos
import com.example.rabindracompose.domain.useCases.home.PhotoUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun provideRoomDb(@ApplicationContext context: Context):RabindraDataBase
    {
        return Room.databaseBuilder(context,RabindraDataBase::class.java,DB_NAME).build()
    }
    @Provides
    @Singleton
    fun providePhotoRepository(api: Api,rabindraDataBase: RabindraDataBase):PhotoRepository = PhotoRepositoryImpl(api,rabindraDataBase)

    @Provides
    @Singleton
    fun providePhotoUseCases(photoRepository: PhotoRepository):PhotoUseCases
    {
        return PhotoUseCases(getPhotos = GetPhotos(photoRepository))
    }

}
