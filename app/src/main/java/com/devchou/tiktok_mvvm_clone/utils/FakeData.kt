package com.devchou.tiktok_mvvm_clone.utils

import com.devchou.tiktok_mvvm_clone.data.models.Video

object FakeData {

    val list = listOf(
        Video(
            id=0,
            url="https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            description = "desc 0",
            tag = "#Test #IT #Halber",
            likes = 20 ,
            views=201,
            author = "@Jon Dao",
            authorImage = null,
            totalCommentsSize = 202
        ),
        Video(
            id=0,
            url="https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
            description = "desc 0",
            tag = "#Test #IT #Halber",
            likes = 20 ,
            views=201,
            author = "@Jon Dao",
            authorImage = "https://cdn-icons-png.flaticon.com/512/147/147140.png",
            totalCommentsSize = 202,
            isLiked = true
        )
    )
}