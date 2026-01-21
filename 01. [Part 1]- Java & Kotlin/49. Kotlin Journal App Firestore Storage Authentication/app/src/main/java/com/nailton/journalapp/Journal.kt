package com.nailton.journalapp

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

data class Journal(
    val title: String,
    val thoughts: String,
    val imageUrl: String,
    val userId: String,
    val timeAdded: String,
    val username: String
) {

    // Adaptador Binding
    // criando esse adaptador conseguimos usar a url da imagemno card
    object DataBindingAdapter {
        @BindingAdapter("imageUrl")
        @JvmStatic
        fun setImageByRes(imageView: ImageView, imageUrl: String) {
            Glide.with(imageView.context)
                .load(imageUrl)
                .into(imageView)
        }
    }
}
