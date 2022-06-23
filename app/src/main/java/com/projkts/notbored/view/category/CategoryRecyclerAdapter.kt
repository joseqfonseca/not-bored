package com.projkts.notbored.view.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.projkts.notbored.databinding.CardCategoryBinding
import com.projkts.notbored.model.Category

class CategoryRecyclerAdapter(
    private val list: List<Category>,
    private val cardListener: (category: Category) -> Unit
) :
    RecyclerView.Adapter<CategoryRecyclerAdapter.CategoryRecyclerHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryRecyclerHolder {
        val bindingCardCategory = CardCategoryBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return CategoryRecyclerHolder(bindingCardCategory)
    }

    override fun onBindViewHolder(viewHolder: CategoryRecyclerHolder, position: Int) {
        viewHolder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    inner class CategoryRecyclerHolder(private val card: CardCategoryBinding) :
        RecyclerView.ViewHolder(card.root) {

        fun bind(category: Category) {
            card.imageCategory.setImageResource(category.imageResource)
            card.textCategory.text = category.title

            card.root.setOnClickListener {
                cardListener(category)
            }
        }
    }
}