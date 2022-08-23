package com.example.navigationwithsafeargs

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val safeArgs: FirstFragmentArgs by navArgs()
        val flowStepNumber = safeArgs.flowStepNumber

        return when (flowStepNumber) {
            2 -> inflater.inflate(R.layout.fragment_second, container, false)
            else -> inflater.inflate(R.layout.fragment_first, container, false)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btn_first_fragment).setOnClickListener {
            findNavController().navigate(R.id.next_action)
        }
    }
}