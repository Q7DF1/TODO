package com.couldbebetter.todo.overview

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Calendar

@Composable
fun TodoTaskScreen() {
    Column {
        TodoTaskTopBar()
        TodoTaskContent()
    }
}


@Composable
fun TodoTaskTopBar() {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier.height(32.dp)
            .padding(horizontal = 8.dp)
    ) {
        IconButton(
            onClick = {/*TODO*/},
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                contentDescription = "arrow back"
            )
        }
        Spacer(modifier = Modifier.weight(1f))
    }
}

@SuppressLint("DefaultLocale")
@Composable
fun TodoTaskContent() {
    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var selectDate by remember { mutableStateOf("") }
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    var datePickerDialog = DatePickerDialog(
        LocalContext.current,
        { _: DatePicker, y: Int, m: Int, d: Int ->
            selectDate = String.format("%04d-%02d-%02d",y,m,d)
        },
        year,
        month,
        day
    )

    Column (
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        Text(
            text = "Task title",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = title,
            onValueChange = {title = it},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .padding(bottom = 16.dp)
        )
        Text(
            text = "Task Description",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = description,
            onValueChange = {title = it},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .height(100.dp)
        )
        Text(
            text = "Set deadline",
            style = MaterialTheme.typography.headlineMedium,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        OutlinedTextField(
            value = selectDate,
            onValueChange = {},
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier.fillMaxWidth()
                .clickable{datePickerDialog.show()}
        )
    }
}
@Preview
@Composable
fun TodoTaskContentPreview() {
    MaterialTheme {
        TodoTaskContent()
    }
}

@Preview
@Composable
fun TodoTaskTopBarPreview() {
    MaterialTheme {
        TodoTaskTopBar()
    }
}

@Preview
@Composable
fun TodoTaskScreenPreview() {
    MaterialTheme {
        TodoTaskScreen()
    }
}