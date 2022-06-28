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

        (activity as AppCompatActivity).supportActionBar?.title="${SignsObject.getTitle(args.positionArg)}"

        if(args.positionArg==0){
            binding.previousSign.isInvisible=true
        }
        else if(args.positionArg==11){
            binding.forwardSign.isInvisible=true
        }

        binding.currentSignImage.setImageResource(SignsObject.getImage(args.positionArg))
        binding.currentSignName.text = SignsObject.getTitle(args.positionArg)
        binding.currentPrevisionText.text= SignsObject.getPrediction(args.positionArg)

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
                "${SignsObject.getTitle(args.positionArg)} - ${SignsObject.getPrediction(args.positionArg)}")
        return shareIntent}

    }

}