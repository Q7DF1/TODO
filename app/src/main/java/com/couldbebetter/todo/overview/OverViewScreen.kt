package com.couldbebetter.todo.overview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.couldbebetter.todo.ui.components.TodoCardContentList
import com.couldbebetter.todo.ui.components.dataSample

@Composable
fun OverViewScreen() {
    Column {
        OverViewTopBar()
        OverviewGreeting()
        TodoCardContentList(dataSample)
    }
}

@Composable
fun OverViewTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp)
            .height(32.dp)
    ) {
        IconButton(
            onClick = {/*TODO*/},
        ) {
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "account icon"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "search icon"
            )
        }
        IconButton(
            onClick = {},
        ) {
            Icon(
                imageVector = Icons.Filled.Notifications,
                contentDescription = "notification icon"
            )
        }
    }
}

@Composable
fun OverviewGreeting() {
    Column {
        Text(
            text = "Hello Blossom",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Let's get started keeping your tasks organized",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(vertical = 8.dp)
        )
    }
}

@Preview
@Composable
fun OverviewGreetingPreview() {
    MaterialTheme {
        OverviewGreeting()
    }
}

@Preview
@Composable
fun OverViewTopBarPreview() {
    MaterialTheme {
        OverViewTopBar()
    }
}

@Preview
@Composable
fun OverviewScreenPreview() {
    MaterialTheme {
        OverViewScreen()
    }
}