package com.ajijul.gmgtest.ui.adapters.viewholders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ajijul.gmgtest.databinding.ItemUserBinding
import com.ajijul.gmgtest.network.models.ResultX

class UserViewHolders(var itemArticleBinding: ItemUserBinding) : RecyclerView.ViewHolder(itemArticleBinding.root) {

    fun bind(user: ResultX) {
        itemArticleBinding.user = user
        itemArticleBinding.executePendingBindings()
    }
}