package io.cmt.services.helper


interface RetroFitCallBack {
    fun responseListener(response: Any? = null, error: String? = null)
}