package com.devchou.tiktok_mvvm_clone.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "videos")
data class Video(
    @PrimaryKey
    var id: Int,
    var url: String,
    var description: String?,
    var tag:  String,
    var likes: Long = 0,
    var views: Long = 0,
    var author: String,
    var authorImage: String?,
    var totalCommentsSize: Long = 0,
    var isLiked: Boolean = false
)
