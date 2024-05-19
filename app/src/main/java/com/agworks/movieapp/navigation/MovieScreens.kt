package com.agworks.movieapp.navigation

// www.google.com/sign_in
enum class MovieScreens {
    HomeScreen,
    DetailScreen;
    companion object{
        fun fromRoute(route: String?):MovieScreens
        = when(route?.substringBefore("/")){
            HomeScreen.name->HomeScreen
            DetailScreen.name ->DetailScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognised")
        }
    }
}