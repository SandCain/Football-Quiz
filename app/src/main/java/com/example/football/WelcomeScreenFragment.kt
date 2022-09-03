package com.example.football

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.football.databinding.FragmentWelcomeScreenBinding
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation


class WelcomeScreenFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentWelcomeScreenBinding =
            DataBindingUtil.inflate(
            inflater, R.layout.fragment_welcome_screen, container, false
        )

        binding.letsplaybutton.setOnClickListener {
                view : View -> Navigation.findNavController(view).
        navigate(R.id.action_welcomeScreenFragment2_to_quizFragment)
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"

        return binding.root
        }

    }


