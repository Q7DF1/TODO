package com.couldbebetter.todo.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.couldbebetter.todo.data.TodoItem

val dataSample: List<TodoItem> = listOf<TodoItem>(
    TodoItem(1,"mingti","212","dadadada",false),
    TodoItem(2,"我要干嘛","什么东西","2025/4/4",true),
    TodoItem(3,"idjak","dadad","2025/5/24",false)
)
@Composable
fun TodoCardContentList(todoList : List<TodoItem>) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        items(items = todoList) { item ->
            TodoCardContent(
                title = item.title,
                content = item.content,
                completed = item.completed,
                date = item.date
            )
        }
    }

}

@Composable
fun TodoCardContent(
    title: String,
    content: String,
    completed: Boolean,
    date: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.padding(horizontal = 8.dp)
        //TODO modifer the card style
    ) {
        Column(
            modifier = modifier
                .clip(RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 8.dp)
        ) {
            Row(modifier = modifier.fillMaxWidth()) {
                TodoCardDescription(
                    title = title,
                    content = content,
                    modifier = modifier
                )
                Spacer(modifier = modifier.weight(1f))
                TodoCardOperation()
            }
            TodoCardMarkAndTime(
                date = date,
                completed = completed,
                modifier = modifier
            )
        }
    }



}
@Composable
fun TodoCardDescription(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text(
            text =title,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = content,
            style = MaterialTheme.typography.bodySmall
        )
    }

}

@Composable
fun TodoCardOperation(
    modifier: Modifier = Modifier
) {
    Column {
        IconButton(
            onClick = {}//TODO edit operation
        ) {
            Icon(
                imageVector = Icons.Filled.Edit,
                contentDescription = "edit",
                modifier = Modifier.size(24.dp),
                tint = Color.Gray
            )
        }
    }
}


@Composable
fun TodoCardMarkAndTime(
    completed: Boolean,
    date: String,
    modifier: Modifier = Modifier
) {
    var marked by remember { mutableStateOf(completed) }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .height(IntrinsicSize.Min)

    ) {

        Text(
            text = date,
            style = MaterialTheme.typography.bodySmall,
            fontWeight = FontWeight.Thin,
        )

        Spacer(modifier = modifier.weight(1f))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.height(IntrinsicSize.Min)
        ) {
            Text(
                text = "Mark as completed",
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Thin,
            )
            Checkbox(
                checked = marked,
                onCheckedChange = {marked = !marked}, //TODO change need to notify model
                modifier = Modifier.align(Alignment.CenterVertically),
                )
        }
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun TodoCardDescriptionPreview() {
    MaterialTheme {
        TodoCardDescription("title","I need to something")
    }
}
@Preview(device = "id:pixel_5")
@Composable
fun TodoCardMarkAndTimePreview() {
    MaterialTheme {
        TodoCardMarkAndTime(dataSample[0].completed, dataSample[0].date)
    }
}
@Preview(device = "id:pixel_5")
@Composable
fun TodoCardOperationPreview() {
    MaterialTheme {
        TodoCardOperation()
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun TodoCardContentPreview() {
    MaterialTheme {
        TodoCardContent(
            dataSample[2].title,
            dataSample[2].content,
            dataSample[2].completed,
            dataSample[2].date
        )
    }
}
@Preview(device = "id:pixel_5")
@Composable
fun TodoCardContentListReview() {
    MaterialTheme {
        TodoCardContentList(dataSample)
    }
}

@Preview(device = "id:pixel_5")
@Composable
fun demo()
{
    Card {
        Column {
            Row {
                Text("hello")
            }
            Row {
                Text("hell1211")
            }
        }
    }

}

