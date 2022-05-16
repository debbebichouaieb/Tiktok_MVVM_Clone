package com.devchou.tiktok_mvvm_clone.data.source.remote.api

import com.devchou.tiktok_mvvm_clone.data.models.Video
import retrofit2.Response
import retrofit2.http.GET

interface VideoApi {

    @GET("videos")
    suspend fun getAllVideos() : Response<List<Video>>

}