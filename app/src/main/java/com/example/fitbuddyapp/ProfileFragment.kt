package com.example.fitbuddyapp

import android.media.MediaDrm
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.fitbuddyapp.databinding.FragmentProfileBinding
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

        binding = FragmentProfileBinding.inflate(layoutInflater)

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
            val db = Firebase.firestore
            var user_data = db.collection("users").document(args.idUser!!)
// Source can be CACHE, SERVER, or DEFAULT.
            val source = Source.CACHE

// Get the document, forcing the SDK to use the offline cache
            user_data.get(source).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Document found in the offline cache
                    val document = task.result
                    binding.textUsername.text = document.getString("name")

                }


            }
        }
    }
}


