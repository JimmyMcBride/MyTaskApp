package com.fireninja.mytaskapp.navigation

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph(start = true)
@NavGraph
annotation class SplashNavGraph(
  val start: Boolean = false
)
