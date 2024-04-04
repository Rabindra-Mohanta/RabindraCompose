package com.example.rabindracompose.presentation.navgraph

sealed class Route(val route:String) {
    object  HomeScreen:Route("homeScreen")
}