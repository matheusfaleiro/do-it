package dev.theuzfaleiro.doit.navigation

import androidx.navigation.NavHostController
import dev.theuzfaleiro.doit.util.Action
import dev.theuzfaleiro.doit.util.Constants.TASK_LIST_SCREEN

class Screens(private val navController: NavHostController) {
    val displayAllTasks: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(TASK_LIST_SCREEN) {
                inclusive = true
            }
        }
    }

    val displayTask: (Int) -> Unit = { taskId ->
        navController.navigate("task/${taskId}")
    }
}