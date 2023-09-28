package com.example.comicslbrarycompose

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comicslbrarycompose.view.CharacterDetailScreen
import com.example.comicslbrarycompose.view.CharactersBottomNav
import com.example.comicslbrarycompose.view.CollectionScreen
import com.example.comicslbrarycompose.view.Destination
import com.example.comicslbrarycompose.view.LibraryScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Navigation() {

    val navController= rememberNavController()

    Scaffold(bottomBar = {
        CharactersBottomNav(navController)

    }) {

        // navhost
        NavHost(navController =navController , startDestination = Destination.LibrarScreen.route ){

            composable(Destination.LibrarScreen.route){
                LibraryScreen(navController = navController)


            }

            composable(Destination.CollectionScreen.route){
                CollectionScreen(navController = navController)
            }

            composable(Destination.CharacterDetailScreen.route){
                CharacterDetailScreen(navController = navController)
            }

        }
    }

}
