package com.example.appsclones.social.instagram

import androidx.annotation.DrawableRes

data class Post(
    val id: Int,
    @DrawableRes val image: Int,
    val publishedAt: String,
    val likes: Int,
    val comments: Int,
    val shares: Int,
    val description: String? = null,
    val userID: Int,
)
