package com.example.tripgo.home.models

import com.example.tripgo.R

//class for BottomNavItem
sealed class BottomNavItem(var title:String, var icon:Int, var screen_route:String){
    object Home : BottomNavItem("Home", R.drawable.ic_round_home_24,"home")
    object Vegetables: BottomNavItem("Veg",R.drawable.ic_round_home_24,"add_post")
    object Fruits: BottomNavItem("Fruits",R.drawable.ic_round_home_24,"notification")
    object Grocery: BottomNavItem("Grocery",R.drawable.ic_baseline_local_grocery_store_24,"grocery")
}