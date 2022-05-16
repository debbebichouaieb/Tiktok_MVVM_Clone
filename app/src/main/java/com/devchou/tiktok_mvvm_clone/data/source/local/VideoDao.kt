package com.devchou.tiktok_mvvm_clone.data.source.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.devchou.tiktok_mvvm_clone.data.models.Video

@Dao
interface VideoDao {
    @Query("SELECT * FROM videos")
    fun getAllVideos() : LiveData<List<Video>>

    @Query("SELECT * FROM videos WHERE id = :id")
    fun getVideo(id: Int): LiveData<Video>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(videos: List<Video>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(video: Video)
}