package com.projkts.notbored.view.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentCategoryBinding
import com.projkts.notbored.model.Activity
import com.projkts.notbored.model.Category
import com.projkts.notbored.repository.ActivityRepository
import com.projkts.notbored.repository.CategoryRepository
import kotlin.properties.Delegates

class CategoryFragment : Fragment(R.layout.fragment_category) {

    val binding: FragmentCategoryBinding by lazy {
        FragmentCategoryBinding.inflate(layoutInflater)
    }

    private var numberParticipants: Int = 0
    private var price: Double? = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        recyclerViewConfig()
        config()

        numberParticipants = arguments?.getString("numberParticipants")?.toInt()!!
        price = arguments?.getString("price")?.toDouble()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onResume() {
        super.onResume()
    }

    private fun config() {
        binding.btnRandom.setOnClickListener {
            openSuggestion(numberParticipants, price, null)
        }
    }

    private fun recyclerViewConfig() {
        binding.recyclerViewCategory.adapter =
            CategoryRecyclerAdapter(
                CategoryRepository.getAll(),
                { cardListener(it) }
            )
        binding.recyclerViewCategory.layoutManager = GridLayoutManager(getContext(), 2)
    }

    private fun cardListener(category: Category) {
        openSuggestion(numberParticipants, price, category)
    }

    private fun openSuggestion(
        numberParticipants: Int,
        price: Double?,
        category: Category?
    ) {
        val bundle = bundleOf(
            "numberParticipants" to numberParticipants,
            "price" to price,
            "category" to category
        )
        findNavController().navigate(R.id.action_categoryFragment_to_suggestionFragment, bundle)
    }

}