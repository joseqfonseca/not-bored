package com.projkts.notbored.view.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.projkts.notbored.R
import com.projkts.notbored.databinding.FragmentCategoryBinding
import com.projkts.notbored.model.Category

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

        return binding.root
    }

    fun recyclerViewConfig() {
        binding.recyclerViewCategory.adapter = CategoryRecyclerAdapter(getCategoryList())
        binding.recyclerViewCategory.layoutManager = GridLayoutManager(getContext(), 2)
    }

    fun getCategoryList(): List<Category> {
        return listOf(
            Category.CHARITY,
            Category.COOKING,
            Category.DIY,
            Category.BUSYWORK,
            Category.EDUCATION,
            Category.MUSIC,
            Category.RECREATIONAL,
            Category.SOCIAL,
            Category.RELAXATION
        )
    }

}