package com.apjake.techquizzes.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.apjake.techquizzes.presentation.home.HomeScreen
import com.apjake.techquizzes.presentation.register.RegisterScreen
import com.apjake.techquizzes.presentation.splash.SplashScreen


@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.SplashScreen.route
    ){
        composable(Screen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(Screen.RegisterScreen.route){
            RegisterScreen(navController)
        }
        composable(Screen.HomeScreen.route){
            HomeScreen(navController)
        }
    }
}