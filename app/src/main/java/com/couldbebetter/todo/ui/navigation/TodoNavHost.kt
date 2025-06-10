package com.couldbebetter.todo.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.couldbebetter.todo.overview.OverViewScreen
import com.couldbebetter.todo.overview.TodoTaskScreen

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
            OverViewScreen()
        }
        composable(route = AddTasks.route) {
            //TODO
            TodoTaskScreen()
        }
        composable(route = Tasks.route) {
            //TODO
            Text("Task")
        }
    }
}