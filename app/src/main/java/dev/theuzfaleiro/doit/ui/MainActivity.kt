package dev.theuzfaleiro.doit.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.migrations.SharedPreferencesView
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.theuzfaleiro.doit.navigation.SetUpNavigation
import dev.theuzfaleiro.doit.ui.theme.DoItTheme
import dev.theuzfaleiro.doit.ui.viewmodel.TaskViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navHostController: NavHostController

    private val taskViewModel: TaskViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DoItTheme {
                navHostController = rememberNavController()
                SetUpNavigation(
                    navHostController = navHostController,
                    taskViewModel = taskViewModel
                )
            }
        }
    }
}