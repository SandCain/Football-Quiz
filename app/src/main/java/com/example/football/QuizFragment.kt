package com.example.football

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.football.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {

    private val quizItem: MutableList<QuizItem> = mutableListOf(
        QuizItem(
            "How many players does each team have on the pitch when a soccer match starts?",
            listOf("11", "8", "12")
        ),
        QuizItem(
            "What should be the circumference of a Size 5 (adult) football?",
            listOf("27\" to 28\"", "24\" to 25\"", "23\" to 24\"")
        ),
        QuizItem(
            "What is given to a player for a very serious personal foul on an opponent?",
            listOf("Red Card", "Green Card", "Yellow Card")
        ),
        QuizItem(
            "To most places in the world, soccer is known as what?",
            listOf("Football", "Footgame", "Legball")
        ),
        QuizItem(
            "Offside. If a player is offside, what action does the referee take?",
            listOf(
                "Awards an indirect free kick to the opposing team",
                "Awards a penalty to the opposing team",
                "Awards a yellow card to the player"
            )
        ),
        QuizItem(
            "What should be the circumference of a Size 5 (adult) football?",
            listOf("17", "11", "23")
        ),
        QuizItem(
            "Excluding the goalkeeper, what part of the body cannot touch the ball?",
            listOf("Arm", "Head", "Shoulder")
        ),
        QuizItem(
            "What is it called when a player, without the ball on the offensive team is behind the last defender, or fullback?",
            listOf("Offside", "Outside", "Field-side")
        ),
        QuizItem(
            "The Ball. The circumference of the ball should not be greater than what?",
            listOf("70", "80", "90")
        ),
        QuizItem(
            "How many minutes are played in a regular game (without injury time or extra time)?",
            listOf("90", "95", "100")
        ),
        QuizItem(
            "What statement describes a proper throw-in?",
            listOf(
                "Both hands must be on the ball behind the head, both feet must be on the ground",
                "Both hands must be on the ball behind the head",
                "Both feet must be on the ground"
            )
        ),
        QuizItem(
            "How big is a regulation official soccer goal?",
            listOf("2.44m high, 7.32m wide", "2.55m high, 7.62m wide", "2.33m high, 8.15m wide")
        )
    )

    lateinit var currentQuizInit: QuizItem
    lateinit var answers: MutableList<String>
    private var quizItemIndex = 0
    private val numberOfQuestions = 3

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater,
            R.layout.fragment_quiz,
            container,
            false
        )
        getRandomQuizItem()
        binding.quizFragment = this
        binding.passButton.setOnClickListener { view: View ->
            val selectedChexBoxId = binding.radioGroupCheck.checkedRadioButtonId

            if (selectedChexBoxId != -1) {
                var answerIndex = 0
                when (selectedChexBoxId) {
                    R.id.firstRadioButton -> answerIndex = 0
                    R.id.secondRadioButton -> answerIndex = 1
                    R.id.thirstRadioButton -> answerIndex = 2
                }
                if (answers[answerIndex] == currentQuizInit.answerList[0]) {
                    quizItemIndex++
                    if (quizItemIndex < numberOfQuestions) {
                        setQuizItem()
                        binding.invalidateAll()
                    } else {
                        view.findNavController().navigate(R.id.action_quizFragment_to_goalFragment)
                    }

                }else {
                    view.findNavController().navigate(R.id.action_quizFragment_to_missFragment)
                }
            }
        }
        (activity as AppCompatActivity).supportActionBar?.title = "Soccer Quiz"

        setHasOptionsMenu(true)


        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_item, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(
            item, requireView().findNavController()
        ) || super.onOptionsItemSelected(item)
    }

    private fun getRandomQuizItem() {
        quizItem.shuffle()
        quizItemIndex = 0
        setQuizItem()
    }

    private fun setQuizItem() {
        currentQuizInit = quizItem[quizItemIndex]
        answers = currentQuizInit.answerList.toMutableList()
        answers.shuffle()
    }
}




