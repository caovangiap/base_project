package com.example.baseapp.base.ui

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.DialogFragment
import com.example.baseapp.databinding.DialogNotificationPermissionBinding

class BaseBottomNotification : DialogFragment() {

    lateinit var  binding : DialogNotificationPermissionBinding
    private var buttonClickAllow: (() -> Unit)? = null
    private var buttonDissMiss : (() -> Unit)? = null
    companion object{

        fun newInstance(
            allow: (() -> Unit)? = null,
            dismiss: (() -> Unit)? = null
        )= BaseBottomNotification().apply {
            buttonClickAllow = allow
            buttonDissMiss = dismiss
        }
    }
    override fun onStart() {
        super.onStart()
        dialog?.window?.let { window ->
            val params = window.attributes
            params.width = WindowManager.LayoutParams.MATCH_PARENT
            params.height = WindowManager.LayoutParams.WRAP_CONTENT
            params.gravity = Gravity.BOTTOM
            params.y = 100
            window.attributes = params
            window.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
            val marginPx = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                16f,
                resources.displayMetrics
            ).toInt()
            window.setLayout(
                resources.displayMetrics.widthPixels - marginPx * 2,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DialogNotificationPermissionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNotNow.setOnClickListener {
            buttonDissMiss?.invoke()
            dismiss()
        }
        binding.btnAllow.setOnClickListener {
            buttonClickAllow?.invoke()
            dismiss()
        }
    }


}