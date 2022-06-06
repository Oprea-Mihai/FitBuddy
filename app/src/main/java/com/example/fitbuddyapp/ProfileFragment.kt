package com.example.fitbuddyapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.fitbuddyapp.databinding.FragmentProfileBinding
import com.google.firebase.firestore.FirebaseFirestore

class ProfileFragment : Fragment() {
    private lateinit var userEmail: String
    private lateinit var userAge: String
    private lateinit var userWeight: String
    private lateinit var userHeight: String
    private lateinit var userID: String
    private lateinit var createAccountInputsArray: Array<EditText>
    private lateinit var binding: FragmentProfileBinding
    private lateinit var firestore: FirebaseFirestore


    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?
    ): View? {

        binding= FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }
    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle=arguments

        if(bundle == null)
        { Log.d("Confirmation","Fragment didn't recve info")
        return}
        val args=ProfileFragmentArgs.fromBundle(bundle)
        if(args.email.isNullOrBlank())
        {
            binding.textView4.text=getString(R.string.noname)
        }
        else{
            binding.textView4.text=args.email
        }
    }



}
