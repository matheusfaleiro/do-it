package dev.theuzfaleiro.doit.ui.screen.alltasks

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Surface
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import dev.theuzfaleiro.doit.R
import dev.theuzfaleiro.doit.components.PriorityItem
import dev.theuzfaleiro.doit.data.model.Priority
import dev.theuzfaleiro.doit.ui.theme.DoItTheme
import dev.theuzfaleiro.doit.ui.theme.MEDIUM_PADDING
import dev.theuzfaleiro.doit.ui.theme.SEARCH_TOP_APP_BAR
import dev.theuzfaleiro.doit.ui.viewmodel.TaskViewModel
import dev.theuzfaleiro.doit.util.AppBarState

@Composable
fun AppBar(taskViewModel: TaskViewModel, appBarState: AppBarState, searchTextState: String) {
    when (appBarState) {
        AppBarState.EXPANDED -> SearchAppBar(
            queryText = searchTextState,
            onTextChanged = { taskViewModel.searchQuery.value = it },
            onSearchClicked = { },
            onClearClicked = {
                taskViewModel.appBarState.value = AppBarState.COLLAPSED
                taskViewModel.searchQuery.value = ""
            })

        AppBarState.COLLAPSED -> DefaultAppBar(
            onSearchClicked = { taskViewModel.appBarState.value = AppBarState.EXPANDED },
            onSortClicked = {},
            onMenuClicked = {})
        AppBarState.TRIGGERED -> TODO()
    }

}

@Composable
private fun DefaultAppBar(
    onSearchClicked: () -> Unit = {},
    onSortClicked: (priority: Priority) -> Unit,
    onMenuClicked: () -> Unit = {}
) {
    SmallTopAppBar(
        title = { Text(stringResource(id = R.string.all_tasks_title_all_tasks)) },
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimaryContainer,
        ),
        actions = {
            AppBarActions(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onMenuClicked = onMenuClicked
            )
        }
    )
}

@Composable
private fun SearchAppBar(
    queryText: String,
    onTextChanged: (String) -> Unit,
    onSearchClicked: (String) -> Unit,
    onClearClicked: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(SEARCH_TOP_APP_BAR),
        elevation = AppBarDefaults.TopAppBarElevation,
        color = MaterialTheme.colorScheme.primary
    ) {
        TextField(
            value = queryText,
            onValueChange = {
                onTextChanged(it)
            },
            placeholder = {
                Text(
                    stringResource(id = R.string.all_tasks_search_placeholder),
                    modifier = Modifier.alpha(ContentAlpha.medium)
                )
            },
            textStyle = TextStyle(
                color = MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.titleMedium.fontSize
            ),
            singleLine = true,
            leadingIcon = {
                IconButton(
                    onClick = { },
                    modifier = Modifier.alpha(ContentAlpha.disabled)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Search,
                        contentDescription = stringResource(id = R.string.content_description_all_tasks_search_tasks)
                    )
                }
            },
            trailingIcon = {
                IconButton(
                    onClick = onClearClicked,
                    modifier = Modifier.alpha(ContentAlpha.disabled)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Clear,
                        contentDescription = stringResource(id = R.string.content_description_all_tasks_clear_search)
                    )
                }
            },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search),
            keyboardActions = KeyboardActions(
                onSearch = { onSearchClicked(queryText) },
            ),
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = MaterialTheme.colorScheme.onPrimaryContainer,
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                backgroundColor = Color.Transparent
            )
        )
    }
}

@Composable
fun AppBarActions(
    onSearchClicked: () -> Unit = {},
    onSortClicked: (priority: Priority) -> Unit,
    onMenuClicked: () -> Unit = {}
) {
    SearchAction(onSearchClicked)

    SortAction(onSortClicked)

    MenuAction(onMenuClicked)
}

@Composable
fun SearchAction(onSearchClicked: () -> Unit) {
    IconButton(onClick = onSearchClicked) {
        Icon(
            imageVector = Icons.Rounded.Search,
            contentDescription = stringResource(id = R.string.content_description_all_tasks_search_tasks),
        )
    }
}


@Composable
fun SortAction(onSortClicked: (Priority) -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    IconButton(onClick = {
        isExpanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = stringResource(id = R.string.content_description_all_tasks_sort_tasks),
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            DropdownMenuItem(onClick = {
                isExpanded = false
                onSortClicked(Priority.LOW)
            }) {
                PriorityItem(Priority.LOW)
            }

            DropdownMenuItem(onClick = {
                isExpanded = false
                onSortClicked(Priority.MEDIUM)
            }) {
                PriorityItem(Priority.MEDIUM)
            }

            DropdownMenuItem(onClick = {
                isExpanded = false
                onSortClicked(Priority.HIGH)
            }) {
                PriorityItem(Priority.HIGH)
            }

            DropdownMenuItem(onClick = { isExpanded = false }) {
                PriorityItem(Priority.UNKNOWN)
            }
        }
    }
}

@Composable
fun MenuAction(onMenuClicked: () -> Unit) {
    var isExpanded by remember { mutableStateOf(false) }

    IconButton(onClick = {
        isExpanded = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_more),
            contentDescription = stringResource(id = R.string.content_description_all_tasks_sort_tasks),
        )

        DropdownMenu(
            expanded = isExpanded,
            onDismissRequest = { isExpanded = false }
        ) {
            DropdownMenuItem(onClick = {
                isExpanded = false
                onMenuClicked()
            }) {
                Text(
                    text = stringResource(id = R.string.all_tasks_menu_delete_all_tasks),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(start = MEDIUM_PADDING)
                )
            }
        }
    }
}

@Preview(
    name = "Light - Search AppBar",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Preview(
    name = "Dark - Search AppBar",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Composable
private fun SearchAppBarPreview() {
    DoItTheme() {
        SearchAppBar(
            queryText = "",
            onTextChanged = {},
            onClearClicked = {},
            onSearchClicked = {}
        )
    }
}