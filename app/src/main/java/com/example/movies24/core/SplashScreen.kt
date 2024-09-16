package com.example.movies24.core

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movies24.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController){
    val scale=remember{androidx.compose.animation.core.Animatable(0f)}
    LaunchedEffect(key1=true){
        scale.animateTo(targetValue=1.3f, animationSpec = tween(durationMillis = 600, easing = {OvershootInterpolator(2f).getInterpolation(it)}))
        delay(100L)
        navController.navigate("main_screen")
    }
    Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.splashimg4_5_removebg), contentDescription = "Logo", modifier = Modifier.size(200.dp).scale(scale.value))
        //scale(scale.value))
    }
}

//todo
//Part of the Documentation read (source Medium):
//Use remember to create an Animatable float value (scale) for animation.
//Employ LaunchedEffect to animate the scale value using tween and OvershootInterpolator for a bouncy effect.
//Add a delay (3 seconds in this example) before navigating to the main_screen.
//Within a Box, display an image using Image composable and scale it based on the animated scale value.
