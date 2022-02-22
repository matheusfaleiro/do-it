package dev.theuzfaleiro.doit.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.theuzfaleiro.doit.ui.screen.alltasks.AllTasksScreen
import dev.theuzfaleiro.doit.ui.viewmodel.TaskViewModel
import dev.theuzfaleiro.doit.util.Constants.TASK_LIST_ARGUMENT_KEY
import dev.theuzfaleiro.doit.util.Constants.TASK_LIST_SCREEN

fun NavGraphBuilder.allTasksComposable(
    navigateToTask: (taskId: Int) -> Unit,
    taskViewModel: TaskViewModel
) {
    composable(
        route = TASK_LIST_SCREEN,
        arguments = listOf(navArgument(TASK_LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        AllTasksScreen(navigateToTaskScreen = navigateToTask, taskViewModel = taskViewModel)
    }
}