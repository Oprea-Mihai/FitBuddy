package com.example.fitbuddyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.fitbuddyapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    public lateinit var navigationView:NavigationView
    lateinit var navController:NavController
    public val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // val navHostFragment=supportFragmentManager.findFragmentById(androidx.navigation.fragment.R.id.nav_host_fragment_container) as NavHostFragment
        //val navController=navHostFragment.navController

      //  navController.addOnDestinationChangedListener { _, destination, _ ->
        //    when (destination.id) {
          //      R.id.signUpFragment -> hideBottomNav()
            //    else -> showBottomNav()
            //}

        //}
    }
    private fun showBottomNav() {
        navigationView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        navigationView.visibility = View.GONE

    }
}

