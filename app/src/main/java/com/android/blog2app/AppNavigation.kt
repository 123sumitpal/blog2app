package com.android.blog2app

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import java.net.URLDecoder
import java.nio.charset.StandardCharsets

@Composable
fun AppNavigation(navController: NavController, viewModel: BlogViewModel) {
    NavHost(navController = navController as NavHostController, startDestination = "blogList") {
        composable("blogList") {
            BlogListScreen(navController = navController, viewModel = viewModel)
        }
        composable("blogWebView/{url}") { backStackEntry ->
            val encodedUrl = backStackEntry.arguments?.getString("url")
            encodedUrl?.let {
                val decodedUrl = URLDecoder.decode(it, StandardCharsets.UTF_8.toString())
                BlogWebViewScreen(url = decodedUrl)
            }
        }
    }
}
