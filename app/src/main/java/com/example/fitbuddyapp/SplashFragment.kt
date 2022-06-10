package com.example.fitbuddyapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        view?.findViewById<View?>(R.id.bottom_view)?.isVisible=false;
        val view=inflater.inflate(R.layout.fragment_splash,container,false)
        Handler(Looper.myLooper()!!).postDelayed({

            findNavController().navigate(R.id.action_splashFragment_to_signInFragment)

        },3500)
        return view

    }
}