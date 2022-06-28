package com.example.fitbuddyapp.ui.exercises

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitbuddyapp.databinding.FragmentExercisesHomeBinding
import com.example.fitbuddyapp.ui.exercises.ExerciseObject.getSignSize
import kotlinx.coroutines.*

class ExercisesHomeFragment : Fragment() {

    private var adapter:RecyclerView.Adapter<ExerciseViewHolder>?=null
    private lateinit var binding:FragmentExercisesHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)
        // Inflate the layout for this fragment
        binding= FragmentExercisesHomeBinding.inflate(inflater)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        (activity as AppCompatActivity).supportActionBar?.title="Exercises"
        binding.recyclerView.layoutManager=LinearLayoutManager(this.context)
        adapter= RecyclerAdapter {
            onSelect(it)
        }

        binding.recyclerView.adapter=adapter

        var job= Job()
        var coroutineScope= CoroutineScope(job+Dispatchers.IO)

        coroutineScope.launch {

            for(index in 0..getSignSize()){
            val sign = ExerciseObject.getTitle(index).lowercase()

            }
        }

    }


    private fun onSelect(position: Int){
        Log.i("Home Fragment", "$position")

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item!!, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}