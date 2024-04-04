package com.example.rabindracompose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rabindracompose.presentation.home.HomeScreen
import com.example.rabindracompose.presentation.home.HomeScreenViewModel

@Composable
fun NavGraph(startDestination:String)
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Route.HomeScreen.route)
        {
            HomeScreen()
        }

    }
}

