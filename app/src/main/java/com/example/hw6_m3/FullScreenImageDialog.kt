package com.example.hw6_m3

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment

class FullScreenImageDialog : DialogFragment() {

    companion object {
        private const val ARG_IMAGE_RES_ID = "image_res_id"

        fun newInstance(imageResId: Int): FullScreenImageDialog {
            return FullScreenImageDialog().apply {
                arguments = Bundle().apply {
                    putInt(ARG_IMAGE_RES_ID, imageResId)
                }
            }
        }
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_fullscreen_image, container, false)
        val imageView: ImageView = view.findViewById(R.id.fullscreenImage)

        arguments?.getInt(ARG_IMAGE_RES_ID)?.let { imageResId ->
            imageView.setImageResource(imageResId)
        }

        view.setOnClickListener { dismiss() }

        return view
    }
}