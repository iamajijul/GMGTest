package com.ajijul.gmgtest.helper

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.ajijul.gmgtest.network.models.Name
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@BindingAdapter("image")
fun ImageView.setUserImage(imgUrl: String?) {
    imgUrl?.let {
        Glide.with(context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("name")
fun TextView.setUserName(name: Name?) {
    this.text = "${name?.title ?: ""} ${name?.first ?: ""} ${name?.last ?: ""}"

}
