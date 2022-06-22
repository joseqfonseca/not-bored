package com.projkts.notbored.view.suggestion

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentSuggestionBinding
import com.projkts.notbored.model.Activity
import com.projkts.notbored.model.Category
import com.projkts.notbored.repository.ActivityRepository

class SuggestionFragment : Fragment() {

    private val binding: FragmentSuggestionBinding by lazy {
        FragmentSuggestionBinding.inflate(layoutInflater)
    }

    private var numberParticipants: Int = 0
    private var price: Double? = 0.0
    private var category: Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        config()

        //reading the parameters from parent
        numberParticipants = arguments?.getInt("numberParticipants")!!
        price = arguments?.getDouble("price")
        category = arguments?.get("category") as Category?

        suggestActivity()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_suggestion, container, false)
    }

    private fun config() {
        binding.button.setOnClickListener {
            /*val dialogLoading = AlertDialog.Builder(requireContext()).apply {
                setMessage("Loading...")
            }*/
            suggestActivity()
        }
    }

    private fun getSortedActivity(
        numberParticipants: Int,
        price: Double?,
        category: Category?
    ): Activity? {
        return ActivityRepository.getAll().filter {
            it.participants == numberParticipants && (price == null || it.price == price) && (category == null || it.category.name == category.name)
        }.randomOrNull()
    }

    private fun suggestActivity() {
        //sorting activity suggestion with the filters
        val activity = getSortedActivity(numberParticipants, price, category)

        //fill the screen fields
        if (activity != null) {
            activity?.let {
                binding.phraseCategory.text =
                    if (category == null) getString(R.string.phrase_random_suggestion) else getString(
                        R.string.phrase_category_suggestion
                    )
                binding.typeActivity.text = it.title
                binding.totalParticipants.text = it.participants.toString()
                binding.typePrice.text = it.getPriceName()
            }
        } else {
            //findNavController().popBackStack()
            //Toast.makeText(requireContext(), "No activity available in this search :/", 2500)
        }
    }
}