package com.example.android_demo_kotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_demo_kotlin.R
import com.example.android_demo_kotlin.interfaces.Communicator
import kotlinx.android.synthetic.main.fragment_add_message.view.btn_send_message
import kotlinx.android.synthetic.main.fragment_add_message.view.editxt_message_fragment

class AddMessageFragment : Fragment() {
    lateinit var communicator: Communicator

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        communicator = activity as Communicator
        view.btn_send_message.setOnClickListener {
            communicator.Datapass(view.editxt_message_fragment.text.toString())
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_message, container, false)
    }
  }
