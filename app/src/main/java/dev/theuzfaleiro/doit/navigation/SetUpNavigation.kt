package dev.theuzfaleiro.doit.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import dev.theuzfaleiro.doit.navigation.destination.allTasksComposable
import dev.theuzfaleiro.doit.navigation.destination.taskComposable
import dev.theuzfaleiro.doit.ui.viewmodel.TaskViewModel
import dev.theuzfaleiro.doit.util.Constants.TASK_LIST_SCREEN

@Composable
fun SetUpNavigation(navHostController: NavHostController, taskViewModel: TaskViewModel) {
    val screen = remember(navHostController) {
        Screens(navHostController)
    }

    NavHost(navController = navHostController, startDestination = TASK_LIST_SCREEN) {
        allTasksComposable(navigateToTask = screen.displayTask, taskViewModel = taskViewModel)

        taskComposable(navigateToAllTasks = screen.displayAllTasks)
    }
}