package com.kodex.marketplase

import androidx.annotation.DrawableRes

data class Food(
    @DrawableRes val imgResource: Int,
    val title: String,
    val desc: String
)

val foodList = listOf(
    Food(R.drawable.freepng1, title = "Veg Burger", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng2, title = "Ice Burger", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng3, title = "Chocolate Burger", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng4, title = "Veg Moscow", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng5, title = "Noodles Burger", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng6, title = "Veg Burger", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng7, title = "Veg Pancake", desc = "Burger starting from Rd 80"),
    Food(R.drawable.freepng8, title = "Veg Burger", desc = "Burger starting from Rd 80")
)
