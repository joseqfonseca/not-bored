package com.projkts.notbored.model

import com.projkts.notbored.R

enum class Category(val title: String, val imageResource: Int = 0) {
    EDUCATION("Education", R.drawable.img_category_education),
    RECREATIONAL("Recreational"),
    SOCIAL("Social"),
    DIY("DIY"),
    CHARITY("Charity"),
    COOKING("Cooking"),
    RELAXATION("Relaxation"),
    MUSIC("Music"),
    BUSYWORK("Busywork")
}