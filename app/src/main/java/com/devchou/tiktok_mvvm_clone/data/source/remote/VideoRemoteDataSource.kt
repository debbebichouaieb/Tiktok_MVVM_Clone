package com.devchou.tiktok_mvvm_clone.data.source.remote

import com.devchou.tiktok_mvvm_clone.data.helpers.Resource
import com.devchou.tiktok_mvvm_clone.data.helpers.safeApiCall
import com.devchou.tiktok_mvvm_clone.data.models.Video
import com.devchou.tiktok_mvvm_clone.data.source.remote.api.VideoApi
import com.devchou.tiktok_mvvm_clone.utils.FakeData
import kotlinx.coroutines.delay
import javax.inject.Inject

class VideoRemoteDataSource
@Inject constructor(
    private val api: VideoApi
) {

    suspend fun getAllVideos() = safeApiCall { api.getAllVideos() }


    suspend fun  fakeVideos() :Resource<List<Video>> {
        delay(6000)

        return Resource.success( FakeData.list)
    }
}