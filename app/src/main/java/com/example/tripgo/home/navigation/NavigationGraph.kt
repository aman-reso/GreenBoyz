package com.example.tripgo.home.navigation

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tripgo.PrepareData.getData
import com.example.tripgo.R
import com.example.tripgo.adapters.HomeMainAdapter
import com.example.tripgo.home.models.BottomNavItem


@Composable
fun BottomNavigationBar(navController: NavHostController, bottomNavItems: List<BottomNavItem>) {
    val context = LocalContext.current
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.White
    ) {
        val currentRoute = currentRoute(navController)
        bottomNavItems.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Red.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.screen_route,
                onClick = {
                    navController.navigate(item.screen_route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val bottomNavItems = listOf(BottomNavItem.Home, BottomNavItem.Vegetables, BottomNavItem.Fruits, BottomNavItem.Grocery)
    Scaffold(
        bottomBar = { BottomNavigationBar(navController, bottomNavItems) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
    )
}

@Composable
private fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.arguments?.getString("route")
}

private fun mToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = BottomNavItem.Home.screen_route) {
        composable(BottomNavItem.Home.screen_route) {
            HomeMainAdapter(homeItems = getData())
        }
        composable(BottomNavItem.Grocery.screen_route) {
           HomeMainAdapter(homeItems = getData())

        }
        composable(BottomNavItem.Vegetables.screen_route) {
            HomeMainAdapter(homeItems = getData())

        }
        composable(BottomNavItem.Fruits.screen_route) {
            HomeMainAdapter(homeItems = getData())

        }
    }
}

@Composable
fun HomeScreen(title: String) {
    Text(text = title)
}
