package com.example.baseapp.base.utils

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.Uri
import android.provider.OpenableColumns
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.BindingAdapter
import androidx.fragment.app.Fragment
import com.example.baseapp.R
import com.example.baseapp.base.ui.BaseBottomDialog
import com.example.baseapp.base.ui.TypeDialog
import timber.log.Timber
import java.text.BreakIterator


fun Fragment.showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showPopUp(
    message: String,
    btnAccess: () -> Unit = {}
): AlertDialog =
    AlertDialog.Builder(this.context)
        .setMessage(message)
        .setPositiveButton("OK") { _, _ -> btnAccess() }
        .show()

// check network connect
fun Context.isNetworkConnected(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val networkCapabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

    return when {
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> {
            false
        }
    }
}


fun BaseBottomDialog.setupDialogToShow(
    @DrawableRes imageRes: Int,
    @StringRes title: Int,
    @StringRes content: Int,
    @StringRes buttonText: Int,
    buttonClickListener: (() -> Unit),
): BaseBottomDialog {

    val dialog = BaseBottomDialog.newInstance(
        imageRes, title, content, buttonText
    )
    dialog.buttonClickListen(buttonClickListener)

    return dialog
}


fun BaseBottomDialog.setUpShowDoubleButton(
    @DrawableRes imageRes: Int,
    @StringRes title: Int,
    @StringRes content: Int,
    @StringRes buttonText: Int,
    deleteChat: () -> Unit
): BaseBottomDialog {
    val dialog = BaseBottomDialog.newInstance(
        imageRes, title, content, buttonText
    )
    dialog.showDoubleButton(deleteChat)

    return dialog
}

fun BaseBottomDialog.showDialogType(
    typeDialog: TypeDialog,
    clickButton: () -> Unit,
    @StringRes notification: Int? = null
): BaseBottomDialog {

    return when (typeDialog) {
        TypeDialog.DialogNotConnectInterNet -> {
            setupDialogToShow(
                R.drawable.ic_no_internet,
                R.string.no_internet,
                R.string.please_check_your_network_connection_and_try_again,
                R.string.retry_cap,
                { clickButton() }
            )
        }

        TypeDialog.DialogSaveError -> {
            setupDialogToShow(
                R.drawable.ic_sever_icon,
                R.string.save_error,
                R.string.unable_to_connect_to_server_please_try_again,
                R.string.retry_cap,
                { clickButton() }
            )
        }

        TypeDialog.DialogAllowNotification -> {
            setupDialogToShow(
                R.drawable.ic_notification,
                R.string.allow_notifications,
                notification ?: R.string.no_internet,
                R.string.retry_cap,
                { clickButton() }
            )
        }
    }
}

@BindingAdapter("lastGraphemeColor")
fun TextView.colorLastGrapheme(@ColorInt color: Int) {
    val raw = this.text?.toString().orEmpty()
    if (raw.isEmpty()) return

    val it = BreakIterator.getCharacterInstance()
    it.setText(raw)
    val end = it.last()
    val start = it.previous()
    if (start == BreakIterator.DONE || end == BreakIterator.DONE) return

    val spannable = SpannableString(raw).apply {
        setSpan(
            ForegroundColorSpan(color),
            start,
            end,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
    }
    this.text = spannable
}

fun Context.dpToPx(dp: Float): Int =
    (dp * resources.displayMetrics.density).toInt()

fun Context.spToPx(sp: Float): Int =
    (sp * resources.displayMetrics.scaledDensity).toInt()

fun Context.getFileNameFromUri(uri: Uri): String? {
    var name: String? = null
    val cursor = contentResolver.query(uri, null, null, null, null)
    cursor?.use {
        if (it.moveToFirst()) {
            val nameIndex = it.getColumnIndex(OpenableColumns.DISPLAY_NAME)
            if (nameIndex >= 0) {
                name = it.getString(nameIndex)
            }
        }
    }
    return name
}

fun Activity.isGestureNavigation(): Boolean {
    runCatching {
        android.provider.Settings.Secure.getInt(contentResolver, "navigation_mode", -1)
    }.getOrNull()?.let { return it == 2 }

    val insets = ViewCompat.getRootWindowInsets(window.decorView) ?: return false
    val navVisible = insets.isVisible(WindowInsetsCompat.Type.navigationBars())
    val navIgnore =
        insets.getInsetsIgnoringVisibility(WindowInsetsCompat.Type.navigationBars()).bottom
    val nav = insets.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom
    val gestures = insets.getInsets(WindowInsetsCompat.Type.systemGestures()).bottom
    if (navIgnore == 0 && gestures > 0) return true

    val threshold = (16 * resources.displayMetrics.density).toInt()
    return !navVisible && (gestures - nav) >= threshold
}

fun Activity.paddingStatusBar(rootView: View) {
    ViewCompat.setOnApplyWindowInsetsListener(rootView) { v, insets ->
        val sysBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
        v.setPadding(v.paddingLeft, sysBars.top, v.paddingRight, sysBars.bottom)
        insets

        val cutout = insets.displayCutout
        val nav = insets.getInsets(WindowInsetsCompat.Type.navigationBars())
        val gesture = insets.getInsets(WindowInsetsCompat.Type.systemGestures())
        val ime = insets.getInsets(WindowInsetsCompat.Type.ime())

        Timber.tag("paddingStatusBar")
            .d("✅ Tai thỏ: ${cutout != null && cutout.boundingRects.isNotEmpty()}✅ Navigation bar (3 phím): ${nav.bottom > 0}✅ Gesture navigation: ${gesture.left > 0 || gesture.right > 0}✅ Bàn phím ảo bật: ${ime.bottom > 0} ")

        insets
    }


}

