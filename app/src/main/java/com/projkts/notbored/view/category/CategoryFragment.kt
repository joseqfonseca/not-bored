package com.projkts.notbored.view.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentCategoryBinding
import com.projkts.notbored.model.Category
import com.projkts.notbored.repository.CategoryRepository

class CategoryFragment : Fragment(R.layout.fragment_category) {

    val binding: FragmentCategoryBinding by lazy {
        FragmentCategoryBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        recyclerViewConfig()

        val numberParticipants = arguments?.getString("numberParticipants")?.toInt()
        val price = arguments?.getString("price")?.toDouble()

        println(numberParticipants)
        println(price)

        return binding.root
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
        Toast.makeText(context, category.title, 2000).show()
    }

}