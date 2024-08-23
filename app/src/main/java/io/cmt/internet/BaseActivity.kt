package io.cmt.internet

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.google.android.material.snackbar.Snackbar
import io.cmt.R
import io.cmt.helper.*


open class BaseActivity : AppCompatActivity() {
    private val classTAG = "BASE_ACT"
    private var internetSnackBar: Snackbar? = null
    var permissionStatus: MutableLiveData<Boolean> = MutableLiveData()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




    }



}