package br.com.house.digital.bugcode.helper

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics

object ViewUtils {
    fun minHeightViewNoActionBar(context: Context): Int {
        var statusBarHeight: Float = 0f
        var minHeight: Int = 0

        val displayMetrics: DisplayMetrics = DisplayMetrics()
        (context as Activity).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics)

        val pxHeight = displayMetrics.heightPixels
        val pxWidth = displayMetrics.widthPixels

        val density: Float = context.getResources().getDisplayMetrics().density
        val dpHeight: Float = displayMetrics.heightPixels / density
        val dpWidth: Float = displayMetrics.widthPixels / density

        // status bar height
        val resourceIdStatusBar: Int = context.getResources().getIdentifier(
            "status_bar_height",
            "dimen",
            "android"
        )

        if (resourceIdStatusBar > 0) {
            statusBarHeight =
                context.getResources().getDimensionPixelSize(resourceIdStatusBar) / density

            minHeight = ((dpHeight - statusBarHeight) * density).toInt()
        }

        return minHeight
    }

    fun convertDpToPixel(dp: Float, context: Context): Float {
        return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT).toFloat()
    }

    fun convertPixelsToDp(px: Float, context: Context): Float {
        return px / (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
    }
}