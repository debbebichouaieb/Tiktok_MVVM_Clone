package com.devchou.tiktok_mvvm_clone.di

import android.content.Context
import com.devchou.tiktok_mvvm_clone.data.source.local.AppDatabase
import com.devchou.tiktok_mvvm_clone.data.source.local.VideoDao
import com.devchou.tiktok_mvvm_clone.data.source.remote.VideoRemoteDataSource
import com.devchou.tiktok_mvvm_clone.data.source.remote.api.VideoApi
import com.devchou.tiktok_mvvm_clone.data.repo.VideoRepo
import com.google.gson.Gson
import com.google.gson.GsonBuilder
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
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) =
        AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl("https://dev/api/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideApi(retrofit: Retrofit): VideoApi =
        retrofit.create(VideoApi::class.java)

    @Singleton
    @Provides
    fun provideRemoteDataSource(api: VideoApi) = VideoRemoteDataSource(api)

    @Singleton
    @Provides
    fun provideLocalDataSource(db: AppDatabase) = db.videoDao()

    @Singleton
    @Provides
    fun provideRepo(
        remoteDataSource: VideoRemoteDataSource,
        localDataSource: VideoDao
    ) = VideoRepo(remoteDataSource, localDataSource)


}