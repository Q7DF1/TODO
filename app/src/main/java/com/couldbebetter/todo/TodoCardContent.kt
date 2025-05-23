package com.couldbebetter.todo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent


@Composable
fun TodoCardContent(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
    ) {
        Row {
            TodoCardDescription("title","I need to Something")
            TodoCardOperation()
        }
        TodoCardMarkAndTime()
    }

}
@Composable
fun TodoCardDescription(
    title: String,
    content: String,
    modifier: Modifier = Modifier
) {
    Column (
        modifier = modifier.padding(start = 8.dp)
    ){
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
fun TodoCardOperation() {
    Column {
        IconButton(
            onClick = {}
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
fun TodoCardMarkAndTime() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .height(IntrinsicSize.Min)

    ) {
        Text(
            text = "2025/5/23",
            style = MaterialTheme.typography.labelSmall,
            fontWeight = FontWeight.Thin,
            modifier = Modifier.padding(end = 8.dp).fillMaxHeight()
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = "Mark as completed",
                style = MaterialTheme.typography.labelSmall,
                fontWeight = FontWeight.Thin,
            )
            Checkbox(
                checked = false,
                onCheckedChange = {},
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
        TodoCardMarkAndTime()
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
        TodoCardContent()
    }
}


