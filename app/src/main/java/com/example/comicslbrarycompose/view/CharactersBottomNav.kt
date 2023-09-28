package com.example.comicslbrarycompose.view

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.comicslbrarycompose.R

@Composable
fun CharactersBottomNav(navController: NavController) {

    BottomNavigation(elevation = 5.dp) {

        val navBackStackEntry=navController.currentBackStackEntryAsState()
        val currentDestination=navBackStackEntry.value?.destination

        val iconLibrary= painterResource(id = R.drawable.ic_library)
        val iconCollection= painterResource(id = R.drawable.ic_collection)

        // bottom nav items

        // library screen
        BottomNavigationItem(selected = currentDestination?.route==Destination.LibrarScreen.route,
            onClick = {
                      navController.navigate(Destination.LibrarScreen.route){

                          popUpTo(Destination.LibrarScreen.route)
                          launchSingleTop=true
                      }
            },
            icon = {
                Icon(painter = iconLibrary, contentDescription =null )
            },
            label = {
                Text(text = Destination.LibrarScreen.route)
            }
        
        )



        BottomNavigationItem(selected = currentDestination?.route==Destination.CollectionScreen.route,
            onClick = {

                      navController.navigate(Destination.CollectionScreen.route){
                          popUpTo(Destination.LibrarScreen.route)

                      }
                      },
            icon = { 
                
                Icon(painter = iconCollection, contentDescription =null )
            },
            label = {
                Text(text = Destination.CollectionScreen.route)
            }
            )




    }



}