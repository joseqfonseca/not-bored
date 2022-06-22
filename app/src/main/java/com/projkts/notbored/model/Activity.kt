package com.projkts.notbored.model

data class Activity(
    val title: String,
    val participants: Int,
    val price: Double,
    val category: Category
){
    fun getPriceName():String {
        return when{
            this.price == 0.0 -> "Free"
            this.price in 0.1..0.3 -> "Low"
            this.price in 0.4..0.6 -> "Medium"
            else -> "High"
        }
    }
}
