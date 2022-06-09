package com.example.fitbuddyapp

import android.media.MediaDrm
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import com.example.fitbuddyapp.databinding.FragmentProfileBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ProfileFragment : Fragment() {
    private lateinit var userEmail: String
    private lateinit var userAge: String
    private lateinit var userWeight: String
    private lateinit var userHeight: String
    private lateinit var userID: String
    private lateinit var createAccountInputsArray: Array<EditText>
    private lateinit var binding: FragmentProfileBinding
    private lateinit var firestore: FirebaseFirestore
    private lateinit var documentsnapshot: DocumentSnapshot
    val db = Firebase.firestore


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Thread.sleep(1000)
        binding = FragmentProfileBinding.inflate(layoutInflater)
  //      view.findViewById(R.id.loadingPanel).setVisibility(View.GONE);

        return binding.root
    }

    override fun onStart() {
        super.onStart()

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle = arguments
        if (bundle == null) {
            Log.d("Confirmation", "Fragment didn't recive info")
            return
        }
        val args = ProfileFragmentArgs.fromBundle(bundle)
        if (args.idUser.isNullOrBlank()) {
            binding.textUsername.text = getString(R.string.noname)
        } else {
            var user_data = db.collection("users").document(args.idUser!!).get().addOnSuccessListener{ result->
                binding.textUsername.text = result.getString("name")
            view.findViewById<View?>(R.id.loadingPanel).isVisible=false;
            }

            }
        }
    }



