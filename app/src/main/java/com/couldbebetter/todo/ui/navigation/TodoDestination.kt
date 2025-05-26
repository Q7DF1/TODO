package com.couldbebetter.todo.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface TodoDestination {
    val icon: ImageVector
    val route:  String
}
data object Home: TodoDestination {
    override val route: String
        get() = "Home"
    override val icon: ImageVector
        get() =Icons.Filled.Home
}

data object Tasks: TodoDestination {
    override val route: String
        get() = "Task"
    override val icon: ImageVector
        get() = Icons.Filled.Check
}
data object AddTasks: TodoDestination {
    override val route: String
        get() = "Add Task"
    override val icon: ImageVector
        get() = Icons.Filled.AddCircle
}

val todoNavScreen = listOf(Home, AddTasks, Tasks)
