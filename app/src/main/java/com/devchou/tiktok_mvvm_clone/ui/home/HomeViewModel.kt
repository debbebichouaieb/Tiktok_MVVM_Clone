package com.devchou.tiktok_mvvm_clone.ui.home

import androidx.lifecycle.ViewModel
import com.devchou.tiktok_mvvm_clone.data.repo.VideoRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
    repo: VideoRepo
) : ViewModel() {


    val videos = repo.getVideos() ;
}