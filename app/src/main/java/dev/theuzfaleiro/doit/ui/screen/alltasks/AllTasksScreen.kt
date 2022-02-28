package dev.theuzfaleiro.doit.ui.screen.alltasks

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import dev.theuzfaleiro.doit.R
import dev.theuzfaleiro.doit.ui.viewmodel.TaskViewModel
import dev.theuzfaleiro.doit.util.AppBarState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AllTasksScreen(navigateToTaskScreen: (taskId: Int) -> Unit, taskViewModel: TaskViewModel) {

    val appBarState: AppBarState by taskViewModel.appBarState

    val searchQuery: String by taskViewModel.searchQuery

    Scaffold(
        topBar = {
            AppBar(
                taskViewModel = taskViewModel,
                appBarState = appBarState,
                searchTextState = searchQuery
            )
        },
        content = {

        },
        floatingActionButton = {
            FloatingActionButton(navigateToTaskScreen = navigateToTaskScreen)
        }
    )
}

@Composable
private fun FloatingActionButton(navigateToTaskScreen: (taskId: Int) -> Unit) {
    FloatingActionButton(
        containerColor = MaterialTheme.colorScheme.primary,
        onClick = {
            navigateToTaskScreen(-1)
        }) {
        Icon(
            imageVector = Icons.Outlined.Add,
            contentDescription = stringResource(id = R.string.content_description_all_tasks_add)
        )
    }
}