package com.apjake.techquizzes.presentation.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.apjake.techquizzes.R
import com.apjake.techquizzes.common.util.AppConstants.SPLASH_SCREEN_LOGO_ANIMATION_DURATION
import com.apjake.techquizzes.presentation.util.Screen


@Composable
fun SplashScreen(
    navController: NavController,
){
    val viewModel: SplashViewModel = hiltViewModel()
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true){
        val animateTo = scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = SPLASH_SCREEN_LOGO_ANIMATION_DURATION,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        viewModel.state.collect{ state->
            if(!state.isLoading){
                navController.popBackStack()
                if(state.hasAccount){
                    navController.navigate(Screen.HomeScreen.route)
                }else{
                    navController.navigate(Screen.RegisterScreen.route)
                }
            }
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.background),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Image(
                painter = painterResource(id = R.drawable.ic_question_purple_dark),
                contentDescription = "Logo",
                modifier = Modifier.size(100.dp),
                colorFilter = ColorFilter.tint(MaterialTheme.colors.onBackground)
            )
        }
    }
}