package com.example.football

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.football.databinding.FragmentGoalBinding


class GoalFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentGoalBinding>(
            inflater,
            R.layout.fragment_goal,
            container,
            false
        )

        binding.oneMoreTimeButton.setOnClickListener { view: View ->
            Navigation.findNavController(view).navigate(R.id.action_goalFragment_to_quizFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"
        return binding.root
    }

}