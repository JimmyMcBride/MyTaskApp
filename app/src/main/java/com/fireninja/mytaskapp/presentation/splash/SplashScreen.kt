package com.fireninja.mytaskapp.presentation.splash

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.fireninja.mytaskapp.ui.theme.LOGO_HEIGHT
import com.fireninja.mytaskapp.utils.Constants.SPLASH_SCREEN_DELAY
import kotlinx.coroutines.delay
import com.fireninja.mytaskapp.R
import com.fireninja.mytaskapp.navigation.AuthNavGraph
import com.fireninja.mytaskapp.navigation.SplashNavGraph
import com.fireninja.mytaskapp.presentation.NavGraphs
import com.fireninja.mytaskapp.presentation.destinations.LoginScreenDestination
import com.fireninja.mytaskapp.presentation.startAppDestination
import com.fireninja.mytaskapp.ui.theme.splashScreenBackgroundColor
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@SplashNavGraph(start = true)
@Destination
@Composable
fun SplashScreen(navigator: DestinationsNavigator) {
  var startAnimation by remember { mutableStateOf(false) }
  val offsetState by animateDpAsState(
    targetValue = if (startAnimation) 0.dp else 100.dp,
    animationSpec = tween(
      durationMillis = 1000
    )
  )
  val alphaState by animateFloatAsState(
    targetValue = if (startAnimation) 1f else 0f,
    animationSpec = tween(
      durationMillis = 1000
    )
  )

  LaunchedEffect(key1 = true) {
    startAnimation = true
    delay(SPLASH_SCREEN_DELAY)
    navigator.navigate(NavGraphs.auth)
  }

  Splash(offsetState, alphaState)
}

@Composable
fun Splash(offsetState: Dp, alphaState: Float) {
  Box(
    modifier = Modifier
      .fillMaxSize()
      .background(MaterialTheme.colors.splashScreenBackgroundColor),
    contentAlignment = Alignment.Center
  ) {
    Image(
      modifier = Modifier
        .size(LOGO_HEIGHT)
        .offset(y = offsetState)
        .alpha(alphaState),
      painter = painterResource(id = R.drawable.ic_launcher_foreground),
      contentDescription = stringResource(id = R.string.app_logo)
    )
  }
}

@Composable
@Preview
private fun SplashScreenPreview() {
  Splash(0.dp, 1f)
}