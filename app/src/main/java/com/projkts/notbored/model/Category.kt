package com.projkts.notbored.model

import com.projkts.notbored.R

enum class Category(val title: String, val imageResource: Int = 0) {
    EDUCATION("Education", R.drawable.img_category_education),
    RECREATIONAL("Recreational", R.drawable.img_category_recreational),
    SOCIAL("Social", R.drawable.img_category_social),
    DIY("DIY", R.drawable.img_category_diy),
    CHARITY("Charity", R.drawable.img_category_charity),
    COOKING("Cooking", R.drawable.img_category_cooking),
    RELAXATION("Relaxation", R.drawable.img_category_relaxation),
    MUSIC("Music", R.drawable.img_category_music),
    BUSYWORK("Busywork", R.drawable.img_category_busywork)
}
