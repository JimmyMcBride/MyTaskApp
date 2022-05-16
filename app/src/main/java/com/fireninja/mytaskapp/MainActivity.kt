package com.fireninja.mytaskapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.ui.Alignment
import com.fireninja.mytaskapp.presentation.NavGraphs
import com.fireninja.mytaskapp.ui.theme.MyTaskAppTheme
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.animations.defaults.NestedNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.defaults.RootNavGraphDefaultAnimations
import com.ramcosta.composedestinations.animations.rememberAnimatedNavHostEngine
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterialNavigationApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      val navHostEngine = rememberAnimatedNavHostEngine(
        navHostContentAlignment = Alignment.TopCenter,
        rootDefaultAnimations = RootNavGraphDefaultAnimations.ACCOMPANIST_FADING,
        defaultAnimationsForNestedNavGraph = mapOf(
          NavGraphs.splash to NestedNavGraphDefaultAnimations(
            exitTransition = {
              slideOutVertically(
                animationSpec = tween(300),
                targetOffsetY = { fullHeight -> -fullHeight }
              )
            }
          )
        ) // all other nav graphs not specified in this map, will get their animations from the `rootDefaultAnimations` above.
      )
      MyTaskAppTheme {
        DestinationsNavHost(navGraph = NavGraphs.root, engine = navHostEngine)
      }
    }
  }
}
