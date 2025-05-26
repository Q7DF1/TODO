package com.couldbebetter.todo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.couldbebetter.todo.ui.navigation.TodoDestination
import com.couldbebetter.todo.ui.navigation.TodoNavHost
import com.couldbebetter.todo.ui.navigation.todoNavScreen

@Composable
fun TodoApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            TodoNavBar(
                allScreens = todoNavScreen,
                onTabSelected = {screen ->
                    navController.navigate(screen.route)
                },
                modifier = Modifier
            )
        }
    ) {
        innerPadding ->
        TodoNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

// alternative

@Composable
fun  TodoNavBarOld() {
    NavigationBar(
        modifier = Modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Home,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "HOME"
                )
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = "TASK"
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun TodoNavBar(
    allScreens: List<TodoDestination>,
    onTabSelected: (TodoDestination) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        allScreens.forEach { screen/*Destination*/ ->
            TodoNavBarItem(
                onSelected = {onTabSelected(screen)},
                description = screen.route,
                imageVector = screen.icon,
                modifier = modifier.weight(1f)
            )
        }
    }
}

@Composable
fun TodoNavBarItem(
    onSelected: () -> Unit,
    description:String,
    imageVector: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier.clickable(
            onClick = onSelected,
            role = Role.Tab
        )
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = description
        )
        Text(text = description)
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun TodoNavBarPreview() {
}