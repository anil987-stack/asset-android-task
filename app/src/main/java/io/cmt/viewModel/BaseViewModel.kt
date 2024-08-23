package io.cmt.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.cmt.helper.IConstants

open class BaseViewModel() : ViewModel() {
    var observerEvents = MutableLiveData<IConstants.ObserverEvents>()
}