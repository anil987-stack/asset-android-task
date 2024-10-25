package io.cmt.app

import android.app.Application


class   AppController : Application() {


    override fun onCreate() {
        super.onCreate()
        if (io.cmt.app.AppController.Companion.instance == null) {
            io.cmt.app.AppController.Companion.instance = this
        }
    }

    companion object {
        var instance: io.cmt.app.AppController? = null
            private set
        var passwordType : String ?= null
        var appEntryType : String ?= null
    }
}