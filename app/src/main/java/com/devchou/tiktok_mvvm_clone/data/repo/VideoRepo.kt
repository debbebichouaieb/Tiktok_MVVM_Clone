package com.devchou.tiktok_mvvm_clone.data.repo

import com.devchou.tiktok_mvvm_clone.data.helpers.resultLiveData
import com.devchou.tiktok_mvvm_clone.data.source.local.VideoDao
import com.devchou.tiktok_mvvm_clone.data.source.remote.VideoRemoteDataSource
import javax.inject.Inject

class VideoRepo @Inject constructor(
    private val remoteDataSource: VideoRemoteDataSource,
    private val localDataSource: VideoDao
) {

    fun getVideos() = resultLiveData(
       databaseQuery= { localDataSource.getAllVideos() },
       networkCall= { remoteDataSource.fakeVideos() },
       saveCallResult= { localDataSource.insertAll(it) }
    )
}