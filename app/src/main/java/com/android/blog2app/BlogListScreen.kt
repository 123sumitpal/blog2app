package com.android.blog2app


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun BlogListScreen(navController: NavController, viewModel: BlogViewModel) {
    val blogPosts = viewModel.blogPosts.observeAsState(listOf())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(blogPosts.value) { post ->
            BlogItem(post = post, onClick = {

                val encodedUrl = URLEncoder.encode(post.link, StandardCharsets.UTF_8.toString())
                navController.navigate("blogWebView/$encodedUrl")
            })
        }
    }

    LaunchedEffect(Unit) {
        viewModel.loadBlogPosts()
    }
}
