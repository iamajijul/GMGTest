package com.ajijul.gmgtest.base

import android.content.Intent
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ajijul.gmgtest.helper.MessageHandlerImp
import com.ajijul.gmgtest.ui.userlist.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment constructor(layoutId: Int) : Fragment(layoutId) {

    protected val viewModel by activityViewModels<UserViewModel>()

    @Inject
    lateinit var messageHandlerImp: MessageHandlerImp

    protected val mainView: View by lazy {
        requireView()

    }

}