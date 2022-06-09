package com.example.fitbuddyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.fitbuddyapp.databinding.FragmentSignInBinding
import com.google.firebase.auth.FirebaseAuth
class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var email: String
    private lateinit var password:String
    private lateinit var signInInputsArray: Array<EditText>
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?
    ): View? {

        //  val view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        //  binding = DataBindingUtil.inflate<SignInFragment>(
        //    inflater, R.layout.fragment_sign_in, container, false)
        binding= FragmentSignInBinding.inflate(layoutInflater)
        //  setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        signInInputsArray= arrayOf(binding.signEmail,binding.signPassword)

        binding.btnSignIn.setOnClickListener {
            signInUser()
            // Toast.makeText(activity, "Buna 1:)", Toast.LENGTH_SHORT).show()
        }
        binding.btnCreateAccount.setOnClickListener{
            view?.findNavController()?.navigate(R.id.action_signInFragment_to_signUpFragment)
        }
        return binding.root
    }
    override fun onStart() {
        super.onStart()

    }

    private fun notEmpty():Boolean{
        return (email.isNotEmpty() && password.isNotEmpty())
    }

    private fun signInUser() {
        email=binding.signEmail.text.toString()
        password=binding.signPassword.text.toString()
        if(notEmpty()){



            firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener() { signIn->
                    if(signIn.isSuccessful){
                        val user=firebaseAuth.currentUser
                        Toast.makeText(activity, "Sign in successful", Toast.LENGTH_SHORT).show()
                        val directions=SignInFragmentDirections.actionSignInFragmentToProfileFragment(
                            user?.uid
                        )
                        findNavController().navigate(directions)

                    }
                    else {
                        Toast.makeText(activity, "Email or password incorrect", Toast.LENGTH_SHORT).show()

                    }

                }
        } else{ Toast.makeText(activity,":(", Toast.LENGTH_SHORT).show()
            signInInputsArray.forEach {
                if(it.text.toString().trim().isEmpty()){
                    it.error="${it.hint} is required"
                }
            }
        }
    }
}
