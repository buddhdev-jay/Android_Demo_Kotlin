package com.example.android_demo_kotlin.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import com.example.android_demo_kotlin.R


class GalleryFragment : Fragment() {
    var imgView: ImageView? = null
    lateinit var btn_choose: Button

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imgView = view.findViewById(R.id.fragment_imgview)
        btn_choose = view.findViewById(R.id.fragment_btn_choose_image)
        val uri = arguments?.getParcelable<Parcelable>(getString(R.string.key_intent))
        imgView?.setImageURI(uri as Uri?)
        btn_choose.setOnClickListener {
            val intent = Intent()
            intent.apply {
                type = getString(R.string.image_receive_type)
                action = Intent.ACTION_GET_CONTENT
            }
            resultLauncher.launch(intent)
        }
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.data.let {
                    imgView?.setImageURI(result.data?.data)
                }
            }
        }
}