package com.example.viewpagerwithcustomtablayout.models

import com.example.viewpagerwithcustomtablayout.R

data class ViewPager2ItemData(
    val image: Int,
    val big_text: String,
    val small_text: String,

    val images: List<Int> = listOf(
        R.drawable.splash1_1,
        R.drawable.splash2_2,
        R.drawable.splash3_3,
        R.drawable.splash4_4,
    ),
)
