package io.cmt.viewModel.activity

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.content.Intent
import android.view.View
import android.view.animation.LinearInterpolator
import io.cmt.R
import io.cmt.helper.IConstants
import io.cmt.view.activity.MainActivity
import io.cmt.view.activity.SplashActivity
import io.cmt.viewModel.BaseViewModel

class SplashVM : BaseViewModel() {

    private val tag = "SPLASH_VM"


    fun setZoomForImage(view: View) {
        val sX = ObjectAnimator.ofFloat(view, View.SCALE_X, 0.1f, 1f)
        val sY = ObjectAnimator.ofFloat(view, View.SCALE_Y, 0.1f, 1f)
        val zoomAnimatorSet = AnimatorSet()
        zoomAnimatorSet.playTogether(sX, sY)
        zoomAnimatorSet.interpolator = LinearInterpolator()
        zoomAnimatorSet.duration = 1200
        zoomAnimatorSet.setTarget(view)
        zoomAnimatorSet.start()
        zoomAnimatorSet.addListener(object : Animator.AnimatorListener {


            override fun onAnimationStart(animation: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animator) {

                openHomeScreenAfterLogin(view.context)
            }

            override fun onAnimationCancel(animation: Animator) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animator) {
                TODO("Not yet implemented")
            }

        })
    }



     private fun openHomeScreenAfterLogin(context: Context) {
        val activity = context as SplashActivity
        val intent = Intent(activity, MainActivity::class.java)
        intent.putExtra(IConstants.IntentStrings.type, IConstants.FragmentTypes.home)
        activity.startActivity(intent)
        activity.finishAffinity()
        activity.overridePendingTransition(R.anim.enter, R.anim.exit)

    }


}