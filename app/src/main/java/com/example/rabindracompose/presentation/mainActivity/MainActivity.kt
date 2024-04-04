package com.example.rabindracompose.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.rabindracompose.presentation.navgraph.NavGraph
import com.example.rabindracompose.ui.theme.RabindraComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //this will hide the topbar
        installSplashScreen()
        setContent {
            RabindraComposeTheme {
                Box(modifier = Modifier.background(color = MaterialTheme.colorScheme.background))
                {
                    val startDestination = "homeScreen"
                    NavGraph(startDestination = startDestination)
                }
            }
        }
    }
}

