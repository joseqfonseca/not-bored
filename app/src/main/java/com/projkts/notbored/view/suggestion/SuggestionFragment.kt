package com.projkts.notbored.view.suggestion

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentSuggestionBinding
import com.projkts.notbored.model.Activity
import com.projkts.notbored.model.Category
import com.projkts.notbored.repository.ActivityRepository

class SuggestionFragment : Fragment(R.layout.fragment_suggestion) {

    private val binding: FragmentSuggestionBinding by lazy {
        FragmentSuggestionBinding.inflate(layoutInflater)
    }

    private var numberParticipants: Int = 0
    private var price: Double? = null
    private var category: Category? = null

    private var currentActivity: Activity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        config()

        //reading the parameters from parent
        numberParticipants = arguments?.getInt("numberParticipants")!!
        price = arguments?.getString("price")?.toDoubleOrNull()
        category = arguments?.get("category") as Category?

        suggestActivity(currentActivity)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    private fun config() {
        binding.buttonTryAnother.setOnClickListener {
            suggestActivity(currentActivity)
        }
    }

    private fun getSortedActivity(
        numberParticipants: Int,
        price: Double?,
        category: Category?,
        currentActivity: Activity?
    ): Activity? {
        return ActivityRepository.getAll().filter {
            it.participants == numberParticipants && (price == null || it.price == price) && (category == null || it.category.name == category.name) && it != currentActivity
        }.randomOrNull()
    }

    private fun suggestActivity(current: Activity?) {
        //sorting activity suggestion with the filters
        val newActivity = getSortedActivity(numberParticipants, price, category, current)

        //fill the screen fields if activity existis
        newActivity?.let {
            binding.phraseCategory.text =
                if (category == null) getString(R.string.phrase_random_suggestion) else getString(R.string.phrase_category_suggestion)
            binding.typeActivity.text = it.category?.title
            binding.chosenSuggestion.text = it.title
            binding.totalParticipants.text = it.participants.toString()
            binding.typePrice.text = it.getPriceName()

            currentActivity = it
            return
        }

        // only if no activity found

        binding.textMsg.run {
            text = if (currentActivity == null) getString(R.string.toast_msg_no_activity_available) else getString(R.string.toast_msg_no_more_activity)
            isVisible = true
        }
    }
}