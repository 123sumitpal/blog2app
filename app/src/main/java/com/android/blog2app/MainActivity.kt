package com.android.blog2app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.android.blog2app.ui.theme.Blog2appTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Blog2appTheme {
                val navController = rememberNavController()
                val viewModel: BlogViewModel = viewModel()
                AppNavigation(navController = navController, viewModel = viewModel)
            }
        }
    }
}

