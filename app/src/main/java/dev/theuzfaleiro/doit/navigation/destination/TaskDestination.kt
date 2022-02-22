package dev.theuzfaleiro.doit.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.theuzfaleiro.doit.util.Action
import dev.theuzfaleiro.doit.util.Constants.TASK_ARGUMENT_KEY
import dev.theuzfaleiro.doit.util.Constants.TASK_LIST_ARGUMENT_KEY
import dev.theuzfaleiro.doit.util.Constants.TASK_LIST_SCREEN
import dev.theuzfaleiro.doit.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(navigateToAllTasks: (Action) -> Unit) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {
    }
}