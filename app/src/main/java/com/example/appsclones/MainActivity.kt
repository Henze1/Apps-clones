package com.example.appsclones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.example.appsclones.social.instagram.Instagram
import com.example.appsclones.ui.theme.AppsClonesTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    companion object {
        val instagramSans = FontFamily(
            Font(R.font.instagram_sans_light, FontWeight.Light),
            Font(R.font.instagram_sans, FontWeight.Normal),
            Font(R.font.instagram_sans_medium, FontWeight.Medium),
            Font(R.font.instagram_sans_bold, FontWeight.Bold),
            Font(R.font.instagram_sans_headline, FontWeight.ExtraBold),
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setStatusBarColor(
                color = Color(0xFF141414),
                darkIcons = false
            )
            systemUiController.setNavigationBarColor(
                color = Color(0xFF141414),
                darkIcons = false
            )
            AppsClonesTheme(
                darkTheme = true,
            ) {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            color = Color(0xFF141414)
                        )
                        .systemBarsPadding()
                ) { innerPadding ->
                    Instagram(
                        Modifier
                            .fillMaxSize()
                            .background(
                                color = Color(0xFF141414)
                            )
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}