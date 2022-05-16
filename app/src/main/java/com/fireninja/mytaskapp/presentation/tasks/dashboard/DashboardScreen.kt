package com.fireninja.mytaskapp.presentation.tasks.dashboard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.fireninja.mytaskapp.navigation.AuthNavGraph
import com.fireninja.mytaskapp.navigation.TaskNavGraph
import com.fireninja.mytaskapp.presentation.NavGraphs
import com.fireninja.mytaskapp.presentation.common.Greeting
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@TaskNavGraph(start = true)
@Destination
@Composable
fun DashboardScreen(
  navigator: DestinationsNavigator,
) {
  Surface(modifier = Modifier.fillMaxSize(),
    color = MaterialTheme.colors.background) {
    Column {
      Greeting("dashboard")
      Button(
        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.error),
        onClick = {
          navigator.navigate(NavGraphs.auth)
        }
      ) {
        Text(text = "Logout")
      }
    }
  }
}