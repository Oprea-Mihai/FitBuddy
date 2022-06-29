package com.example.fitbuddyapp.ui.exercises

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.fitbuddyapp.R
import com.example.fitbuddyapp.databinding.CurrentExerciseFragmentBinding

class CurrentExercise:Fragment(R.layout.current_exercise_fragment) {

    private lateinit var binding:CurrentExerciseFragmentBinding
    private val args: CurrentExerciseArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= CurrentExerciseFragmentBinding.inflate(inflater)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).supportActionBar?.title="${ExerciseObject.getTitle(args.positionArg)}"

        if(args.positionArg==0){
            binding.previousSign.isInvisible=true
        }
        else if(args.positionArg==11){
            binding.forwardSign.isInvisible=true
        }

        binding.currentSignImage.setImageResource(ExerciseObject.getImage(args.positionArg))
        binding.currentSignName.text = ExerciseObject.getTitle(args.positionArg)
        binding.currentPrevisionText.text= ExerciseObject.getDifficulty(args.positionArg)

        binding.previousSign.setOnClickListener{


    }
    fun onStart() {
        super.onStart()
    }

    fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        }

    fun getShareIntent():Intent {
        var arg= arguments?.let { CurrentExerciseArgs.fromBundle(it) }
        val shareIntent= Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain")
            .putExtra(Intent.EXTRA_TEXT,
                "${ExerciseObject.getTitle(args.positionArg)} - ${ExerciseObject.getDifficulty(args.positionArg)}")
        return shareIntent}

    }

}