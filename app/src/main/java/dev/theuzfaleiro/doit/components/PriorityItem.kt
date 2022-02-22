package dev.theuzfaleiro.doit.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.theuzfaleiro.doit.data.model.Priority
import dev.theuzfaleiro.doit.ui.theme.DoItTheme
import dev.theuzfaleiro.doit.ui.theme.MEDIUM_PADDING
import dev.theuzfaleiro.doit.ui.theme.PRIORITY_INDICATOR_SIZE

@Composable
fun PriorityItem(priority: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(modifier = Modifier.size(PRIORITY_INDICATOR_SIZE)) {
            drawCircle(color = priority.color)
        }

        Text(
            text = priority.name,
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = MEDIUM_PADDING)
        )
    }
}

@Preview
@Composable
fun PriorityItem() {
    DoItTheme {
        PriorityItem(Priority.LOW)
    }
}