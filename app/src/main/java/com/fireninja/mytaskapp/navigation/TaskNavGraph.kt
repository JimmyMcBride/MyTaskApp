package com.fireninja.mytaskapp.navigation

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@NavGraph
annotation class TaskNavGraph(
  val start: Boolean = false
)
