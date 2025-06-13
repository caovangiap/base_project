package com.example.save_vehicle_2025_kotlin.main.utils

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

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



