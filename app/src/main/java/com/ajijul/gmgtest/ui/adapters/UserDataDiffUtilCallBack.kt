package com.ajijul.gmgtest.ui.adapters

import androidx.recyclerview.widget.DiffUtil
import com.ajijul.gmgtest.network.models.ResultX

class UserDataDiffUtilCallBack : DiffUtil.ItemCallback<ResultX>() {
    override fun areItemsTheSame(oldItem: ResultX, newItem: ResultX): Boolean {
        return oldItem.email == newItem.email
    }

    override fun areContentsTheSame(oldItem: ResultX, newItem: ResultX): Boolean {
        return oldItem.name?.first == newItem.name?.first
                && oldItem.email == newItem.email
                && oldItem.phone == newItem.phone
    }

}