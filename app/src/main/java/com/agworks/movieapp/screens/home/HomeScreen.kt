package com.agworks.movieapp.screens.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.agworks.movieapp.MovieRow
import com.agworks.movieapp.navigation.MovieScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Movies"
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(Color.Magenta),
                modifier = Modifier
                    .shadow(
                        elevation = 5.dp
                    )
            )
        }
    ) {
        MainContent(
            modifier = Modifier.padding(it),
            navController = navController
        )
    }
}


@Composable
fun MainContent(
    navController: NavController,
    modifier: Modifier, movieList: List<String> = listOf(
        "Avatar",
        "300",
        "Harry Potter",
        "Life",
        "Love of Life",
        "Yes"
    )
) {
    Column(
        modifier = modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(
                items = movieList
            ) {
                MovieRow(movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailScreen.name)
                    Log.d("TAG", "Movie Content $movie")
                }
            }
        }
    }
}
