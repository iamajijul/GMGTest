package com.ajijul.gmgtest.helper

import android.view.View

interface MessageHandler {

    fun showSnackErrorWithAction(view: View, actionName: Int, msg: Int, action: () -> Unit)
    fun showSnackErrorWithAction(view: View, actionName: String, msg: String, action: () -> Unit)
    fun showSnackSuccess(view: View, msg: Int, long: Boolean = false)

}