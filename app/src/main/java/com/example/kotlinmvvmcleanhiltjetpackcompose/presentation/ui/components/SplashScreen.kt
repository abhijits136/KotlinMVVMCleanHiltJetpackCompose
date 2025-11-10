package com.example.kotlinmvvmcleanhiltjetpackcompose.presentation.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.kotlinmvvmcleanhiltjetpackcompose.R

@Composable
fun SplashScreen(
    onInitComplete: () -> Unit,
    showProgress: Boolean,
    brandingRes: Int,
    initTasks: suspend () -> Unit
) {
    LaunchedEffect(Unit) {
        initTasks()
        onInitComplete()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = brandingRes), contentDescription = "Branding Logo")
        if (showProgress) {
            CircularProgressIndicator(modifier = Modifier.padding(top = 16.dp))
        }
    }
}
