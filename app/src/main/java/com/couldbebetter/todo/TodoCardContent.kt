package com.couldbebetter.todo

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TodoCardContent() {

}
@Composable
fun TodoCardDescription() {

}

@Composable
fun TodoCardOperation() {

}


@Composable
fun TodoCardMarkAndTime() {
    Row(
    ) {
        Text(
            text = "todo item"
        )
        Checkbox(
            checked = false,
            onCheckedChange = {},
        )
    }
}
@Preview(device = "id:pixel_5")
@Composable
fun TodoCardMarkAndTimePreview() {
    MaterialTheme {
        TodoCardMarkAndTimePreview()
    }
}