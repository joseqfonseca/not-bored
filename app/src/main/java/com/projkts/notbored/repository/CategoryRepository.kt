package com.projkts.notbored.repository

import com.projkts.notbored.model.Category

class CategoryRepository {
    companion object {
        fun getAll(): List<Category> {
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
}