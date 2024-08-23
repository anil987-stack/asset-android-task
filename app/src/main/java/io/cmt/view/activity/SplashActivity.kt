package io.cmt.view.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import io.cmt.databinding.ActivitySplashBinding
import io.cmt.internet.BaseActivity
import io.cmt.viewModel.activity.SplashVM

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity() {
    private val tag = "SPLASH_ACT"

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater).apply {
            viewModel = ViewModelProvider(this@SplashActivity)[SplashVM::class.java]
            lifecycleOwner = this@SplashActivity
        }
        setContentView(binding.root)
        binding.viewModel?.setZoomForImage(binding.imgSplash)
    }

}