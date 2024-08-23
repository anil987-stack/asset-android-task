package io.cmt.helper

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

class GenericTextWatcher(
    private val etCurrent: TextInputEditText,
    private val etNext: TextInputEditText,
    private val etPrev: EditText
) :
    TextWatcher {
    override fun afterTextChanged(editable: Editable) {
        val text = editable.toString()
        if (text.length == 1) etNext.requestFocus() else if (text.isEmpty()) etPrev.requestFocus()
    }

    override fun beforeTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {}
    override fun onTextChanged(arg0: CharSequence, arg1: Int, arg2: Int, arg3: Int) {
        /*if (etCurrent.text.isNullOrEmpty()) {
            DrawableCompat.setTint(
                etCurrent.background,
                ContextCompat.getColor(etPrev.context, R.color.colorLightBackground)
            )
        } else {
            DrawableCompat.setTint(etCurrent.background, ContextCompat.getColor(etPrev.context, R.color.colorPrimary))
        }*/
    }
}