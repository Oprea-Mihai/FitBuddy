package com.example.fitbuddyapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.findNavController
import com.example.fitbuddyapp.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpFragment : Fragment() {
    private lateinit var userEmail: String
    private lateinit var userPassword: String
    private lateinit var userConfirmPassword: String
    private lateinit var createAccountInputsArray: Array<EditText>
    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView( inflater: LayoutInflater, container: ViewGroup?,
                               savedInstanceState: Bundle?
    ): View? {

        binding= FragmentSignUpBinding.inflate(layoutInflater)

        createAccountInputsArray= arrayOf(
            binding.etEmail,
            binding.etPassword,
            binding.etConfirmPassword)

        binding.btnCreateAccount.setOnClickListener {
            signIn()
        }
        return binding.root
    }
    override fun onStart() {
        super.onStart()
//Asta ca sa se logheze automat
        //  val user: FirebaseUser? = FirebaseUtils.firebaseAuth.currentUser
        //  user?.let {
        //     view?.findNavController()?.navigate(R.id.action_signUpFragment_to_feedFragment)
        //     Toast.makeText(activity, "Welcome Back", Toast.LENGTH_SHORT).show()
        // }

    }

    //campurile sa fie completate
    private fun notEmpty(): Boolean{
        val email=binding.etEmail.text
        val password=binding.etPassword.text
        val confirmPassword=binding.etConfirmPassword.text

        return (email.isNotEmpty() && password.isNotEmpty() && confirmPassword.isNotEmpty())
    }

    private  fun identicalPasswords():Boolean{

        if(binding.etPassword.text.toString()==binding.etConfirmPassword.text.toString() && notEmpty()){
            return true
        }
        else if(!notEmpty()){
            createAccountInputsArray.forEach { input ->
                if(input.text.toString().trim().isEmpty()){
                    input.error = "${input.hint} is required"
                }
            }
        }
        else
        {       Toast.makeText(activity, "Passwords are not matching", Toast.LENGTH_SHORT).show()
        }
        return false
    }

    private fun signIn() {
        if(identicalPasswords()){
            userEmail=binding.etEmail.text.toString()
            userPassword=binding.etPassword.text.toString()
            userConfirmPassword=binding.etConfirmPassword.text.toString()
            //creeare user

            val firebaseAuth: FirebaseAuth = FirebaseAuth.getInstance()
            firebaseAuth.createUserWithEmailAndPassword(userEmail,userPassword)
                .addOnCompleteListener { task->
                    if(task.isSuccessful){
                        Toast.makeText(activity, "Created Account Successfully!", Toast.LENGTH_SHORT).show()
                        view?.findNavController()?.navigate(R.id.action_signUpFragment_to_profileFragment)
                        Toast.makeText(activity, "Created Account Successfully!", Toast.LENGTH_SHORT).show()
                    } else{
                        Toast.makeText(activity, "Failed to create", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }

}
