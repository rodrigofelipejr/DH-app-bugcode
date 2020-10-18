package br.com.house.digital.bugcode.helper

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

object ToastUtils {
    fun toastLong(str: String, context: Context) {
        Toast.makeText(context, str, Toast.LENGTH_LONG).show()
    }

    fun toastShort(str: String, context: Context) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show()
    }

    fun snackbarLong(view:View, str: String){
        Snackbar.make(view, str, Snackbar.LENGTH_LONG).show()
    }
}