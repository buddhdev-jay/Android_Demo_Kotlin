package com.example.android_demo_kotlin.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android_demo_kotlin.R

class ViewMessageFragment : Fragment() {
    lateinit var messageTxtView: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_view_message, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        messageTxtView = view.findViewById(R.id.txtview_message_fragment)
        messageTxtView.text = arguments?.getString(getString(R.string.key_message_intent))
    }
}