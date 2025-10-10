package com.example.baseapp.base.ui

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.fragment.app.DialogFragment
import com.example.baseapp.databinding.BaseBottomDialogBinding
import androidx.core.graphics.drawable.toDrawable

open class BaseBottomDialog : DialogFragment() {


    companion object {
        private const val ARG_IMAGE = "image"
        private const val ARG_TITLE = "title"
        private const val ARG_CONTENT = "content"
        private const val ARG_BUTTON = "button"

        fun newInstance(
            @DrawableRes imageRes: Int,
            @StringRes title: Int,
            @StringRes content: Int,
            @StringRes buttonText: Int,
        ) = BaseBottomDialog().apply {
            arguments = Bundle().apply {
                putInt(ARG_IMAGE, imageRes)
                putInt(ARG_TITLE, title)
                putInt(ARG_CONTENT, content)
                putInt(ARG_BUTTON, buttonText)
            }
        }
    }
    private var showDoubleButtonAccess = false

    fun buttonClickListen(buttonClickListener: (() -> Unit)?){
        buttonClick = buttonClickListener
    }

    private var deleteButtonClick : (() -> Unit)? = null

    private lateinit var _binding: BaseBottomDialogBinding

    private var buttonClick: (() -> Unit)? = null

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
        _binding = BaseBottomDialogBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding.cancelDialog.setOnClickListener {
            dismiss()
        }
        _binding.button.setOnClickListener {
            buttonClick?.invoke()
        }
        val args = requireArguments()
        _binding.imgTypeDialog.setImageResource(args.getInt(ARG_IMAGE))
        _binding.titleDialog.setText(args.getInt(ARG_TITLE))
        _binding.contentNotificationDialog.setText(args.getInt(ARG_CONTENT))
        _binding.button.setText(args.getInt(ARG_BUTTON))

        _binding.btnCancel.setOnClickListener {
            dismiss()
        }
        _binding.btnDelete.setOnClickListener {
            deleteButtonClick?.invoke()
            dismiss()
        }
        if (showDoubleButtonAccess){
            _binding.buttonContainer.visibility = View.VISIBLE
            _binding.button.visibility = View.GONE
        }
    }

    fun showDoubleButton(deleteChat: () -> Unit){
        showDoubleButtonAccess = true
        deleteButtonClick = deleteChat
    }


}

sealed class TypeDialog(){
    object DialogNotConnectInterNet: TypeDialog()
    object DialogSaveError : TypeDialog()
    object DialogAllowNotification : TypeDialog()
}