package com.example.comicslbrarycompose

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.comicslbrarycompose.view.CharacterDetailScreen
import com.example.comicslbrarycompose.view.CollectionScreen
import com.example.comicslbrarycompose.view.Destination
import com.example.comicslbrarycompose.view.LibraryScreen

@Composable
fun Navigation() {

    //navcontroller
    val navController= rememberNavController()

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
