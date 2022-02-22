package dev.theuzfaleiro.doit.util

object Constants {
    const val TODO_DATABASE_NAME = "TODO_DATABASE"
    const val TODO_DATABASE_TASK_TABLE_NAME = "TASK_TABLE"

    const val TASK_LIST_ARGUMENT_KEY = "action"
    const val TASK_ARGUMENT_KEY = "id"

    const val TASK_LIST_SCREEN = "list/{$TASK_ARGUMENT_KEY}"
    const val TASK_SCREEN = "task/{$TASK_LIST_ARGUMENT_KEY}"

}