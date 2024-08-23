package io.cmt.view.activity

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout.LOCK_MODE_LOCKED_CLOSED
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import io.cmt.BuildConfig
import io.cmt.R
import io.cmt.databinding.ActivityMainBinding
import io.cmt.helper.IConstants
import io.cmt.internet.BaseActivity
import io.cmt.viewModel.activity.MainActivityVM

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding


    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            viewModel = ViewModelProvider(this@MainActivity).get(MainActivityVM::class.java)
            lifecycleOwner = this@MainActivity
        }

        setContentView(binding.root)



    }




}

