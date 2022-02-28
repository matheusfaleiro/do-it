package dev.theuzfaleiro.doit.ui.screen.alltasks

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import dev.theuzfaleiro.doit.data.model.Priority
import dev.theuzfaleiro.doit.data.model.Task
import dev.theuzfaleiro.doit.domain.entity.PriorityDto
import dev.theuzfaleiro.doit.domain.entity.TaskDto
import dev.theuzfaleiro.doit.ui.theme.DoItTheme
import dev.theuzfaleiro.doit.ui.theme.LARGE_PADDING
import dev.theuzfaleiro.doit.ui.theme.PRIORITY_INDICATOR_SIZE
import dev.theuzfaleiro.doit.ui.theme.SMALL_PADDING
import dev.theuzfaleiro.doit.ui.theme.TASK_ITEM_ELEVATION

@Composable
fun TaskContent() {
    TaskItem(task = Task(
        taskDto = TaskDto(
            id = 0,
            title = "",
            description = "",
            priorityDto = PriorityDto.HIGH
        )
    ), navigateToTask = {})
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun TaskItem(task: Task, navigateToTask: (taskId: Int) -> Unit) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = MaterialTheme.colorScheme.primary,
        shape = RectangleShape,
        elevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTask(task.id)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(all = LARGE_PADDING)
        ) {
            Row {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    modifier = Modifier.weight(weight = .8f)
                )

                Box(
                    modifier = Modifier.weight(weight = .1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .width(PRIORITY_INDICATOR_SIZE)
                            .height(PRIORITY_INDICATOR_SIZE)
                    ) {
                        drawCircle(color = task.priority.color)
                    }
                }
            }

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = SMALL_PADDING),
                text = task.description,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

    }

}

@Preview
@Composable
fun TaskContentPreview() {
    DoItTheme {
        TaskItem(task = Task(
            id = 1,
            title = "Finish the App",
            description = "Sample Description",
            priority = Priority.MEDIUM
        ), navigateToTask = {})
    }
}