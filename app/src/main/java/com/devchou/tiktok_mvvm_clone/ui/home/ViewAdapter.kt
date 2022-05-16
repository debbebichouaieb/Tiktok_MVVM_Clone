package com.devchou.tiktok_mvvm_clone.ui.home

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.core.widget.ImageViewCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.devchou.tiktok_mvvm_clone.R
import com.devchou.tiktok_mvvm_clone.data.models.Video
import com.devchou.tiktok_mvvm_clone.databinding.ViewItemBinding
import com.devchou.tiktok_mvvm_clone.utils.NumbersUtils
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer

class ViewAdapter :ListAdapter<Video ,ViewAdapter.ViewHolder>(DiffCallback()) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vid = getItem(position)
        holder.apply {
            bind(vid)
            itemView.tag = vid
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ViewItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }


    class ViewHolder(
        private val binding: ViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind( item: Video) {
            binding.apply {
                video = item
                executePendingBindings()
            }
            val simpleExoPlayerView = SimpleExoPlayer.Builder(binding.root.context)
                .setUseLazyPreparation(true)
                .build()

            simpleExoPlayerView.setMediaItem(MediaItem.fromUri(Uri.parse(item.url)))

            binding.simpleExoPlayerView.player =  simpleExoPlayerView

            binding.simpleExoPlayerView.setShutterBackgroundColor(Color.TRANSPARENT)
            binding.simpleExoPlayerView.requestFocus()
            Glide.with(binding.root).load(item.authorImage).into(binding.authorIcon)
            simpleExoPlayerView.prepare()
            simpleExoPlayerView.play()


        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Video>() {

    override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
        return oldItem == newItem
    }
}

@BindingAdapter("formatVideoCount")
fun TextView.formatVideoCount(count: Int) {
    text = NumbersUtils.formatCount(count)
}

@BindingAdapter("changeVideoLikedIcon")
fun ImageView.changeVideoLikedIcon(isLiked: Boolean) {
    val colorStateList = ResourcesCompat.getColorStateList(
        resources,
        if (isLiked) R.color.pinkBtnBackground else android.R.color.white,
        null
    )

    ImageViewCompat.setImageTintList(this, colorStateList)
}