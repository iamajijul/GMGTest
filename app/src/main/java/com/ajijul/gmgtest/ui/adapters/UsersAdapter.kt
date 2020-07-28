package com.ajijul.gmgtest.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import com.ajijul.gmgtest.databinding.ItemUserBinding
import com.ajijul.gmgtest.network.models.ResultX
import com.ajijul.gmgtest.ui.adapters.viewholders.UserViewHolders

class UsersAdapter : PagedListAdapter<ResultX, UserViewHolders>(UserDataDiffUtilCallBack()) {
    private var onItemClickListener: ((ResultX) -> Unit)? = null
    fun setOnClickListener(listener: ((ResultX) -> Unit)) {
        onItemClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolders {
        return UserViewHolders(
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserViewHolders, position: Int) {
       val user =  getItem(position)?.also { holder.bind(it) }
        holder.itemView.setOnClickListener {
            onItemClickListener?.let {
                it(user?:return@let)
            }
        }
    }

}