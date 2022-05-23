package com.apjake.techquizzes.presentation.util

sealed class Screen(val route: String) {
    object SplashScreen: Screen("splash_screen")
    object HomeScreen: Screen("home_screen")
    object RegisterScreen: Screen("register_screen")
    object UserProfileScreen: Screen("user_profile_screen")
    object EditProfileScreen: Screen("edit_profile_screen")
    object SubCategoriesScreen: Screen("sub_categories_screen")
    object QuizScreen: Screen("quiz_screen")
    object ResultScreen: Screen("result_screen")
}