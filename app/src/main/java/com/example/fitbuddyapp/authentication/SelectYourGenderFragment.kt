package com.example.fitbuddyapp.authentication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fitbuddyapp.R
import com.example.fitbuddyapp.databinding.FragmentSelectYourGenderBinding

class SelectYourGenderFragment : Fragment() {
    private lateinit var binding:FragmentSelectYourGenderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSelectYourGenderBinding.inflate(layoutInflater)
        binding.imgMale.setOnClickListener{
            val directions=SelectYourGenderFragmentDirections.actionSelectYourGenderFragmentToMain2Activity()
            findNavController().navigate(directions)
        }

        binding.imgFemale.setOnClickListener{
            val directions=SelectYourGenderFragmentDirections.actionSelectYourGenderFragmentToMain2Activity()
            findNavController().navigate(directions)
        }

        return binding.root
    }
}