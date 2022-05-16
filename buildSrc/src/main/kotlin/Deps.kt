import Versions.coroutines
import Versions.datastore
import Versions.hilt
import Versions.navigation

object Versions {
  const val gradle = "7.1.3"
  const val kotlin = "1.6.10"
  const val jvm = "11"
  const val compose = "1.1.1"
  const val hilt = "2.41"
  const val coroutines = "1.6.1"
//  const val accompanist = "0.24.8-beta"
  const val datastore = "1.0.0"
  const val navigation = "1.5.5-beta"
  const val ksp = "1.6.10-1.0.2"
  const val retrofit = "2.9.0"
}

object Deps {
  // Hilt
  const val hiltAndroid = "com.google.dagger:hilt-android:$hilt"
  const val hiltCompiler = "com.google.dagger:hilt-compiler:$hilt"
  // Coroutines
  const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutines"
  // Accompanist Navigation Animation
//  const val accompanistNavigationAnimation = "com.google.accompanist:accompanist-navigation-animation:$accompanist"
  // Datastore dependencies
  const val datastorePreferences = "androidx.datastore:datastore-preferences:$datastore"
  // Compose Navigation
  const val composeNavigationCore = "io.github.raamcosta.compose-destinations:animations-core:$navigation"
  const val composeNavigationKsp = "io.github.raamcosta.compose-destinations:ksp:$navigation"
  // Retrofit
}