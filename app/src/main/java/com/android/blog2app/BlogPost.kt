package com.android.blog2app
data class BlogPost(
    val id: Int,
    val title: Title,
    val content: Content,
    val link: String,
    val author: String,
    val date: String
)

data class Title(val rendered: String)
data class Content(val rendered: String)