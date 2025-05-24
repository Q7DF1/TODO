package com.couldbebetter.todo.ui.theme.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun TodoNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
        composable(route = Home.route) {
            //TODO
            Text("home")
        }
        composable(route = AddTasks.route) {
            //TODO
            Text("Add Task")
        }
        composable(route = Tasks.route) {
            //TODO
            Text("Task")
        }
    }
}