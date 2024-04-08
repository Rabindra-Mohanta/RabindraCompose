package com.example.rabindracompose.presentation.navgraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.rabindracompose.domain.model.home.PhotosData
import com.example.rabindracompose.presentation.details.DetailsScreen
import com.example.rabindracompose.presentation.home.HomeScreen
import com.example.rabindracompose.presentation.home.HomeScreenViewModel

@Composable
fun NavGraph(startDestination:String)
{
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Route.HomeScreen.route)
        {
            val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
            val photoData = homeScreenViewModel.photoData.collectAsLazyPagingItems()
            HomeScreen(photoData){
                navController.currentBackStackEntry?.savedStateHandle?.set("data",it)
                navController.navigate(Route.DetailsScreen.route)


            }

        }
        
        composable(route = Route.DetailsScreen.route)
        {
                val photoData = navController.previousBackStackEntry?.savedStateHandle?.get<PhotosData>("data")
               photoData?.let {
                   DetailsScreen(it)

               }


        }

    }
}

