package com.ajijul.gmgtest.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ajijul.gmgtest.R
import com.ajijul.gmgtest.base.BaseActivity

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}