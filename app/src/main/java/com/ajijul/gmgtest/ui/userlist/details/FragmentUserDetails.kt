package com.ajijul.gmgtest.ui.userlist.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.ajijul.gmgtest.R
import com.ajijul.gmgtest.base.BaseFragment
import com.ajijul.gmgtest.databinding.FragmentUserDetailsBinding

class FragmentUserDetails : BaseFragment(R.layout.fragment_list_of_user) {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        binding.user = viewModel.selectedUser
        return binding.root
    }
}