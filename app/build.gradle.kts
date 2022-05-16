plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("dagger.hilt.android.plugin")
  id("kotlin-kapt")
  id("com.google.devtools.ksp") version Versions.ksp
}

android {
  compileSdk = 31

  defaultConfig {
    applicationId = "com.fireninja.mytaskapp"
    minSdk = 21
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    vectorDrawables {
      useSupportLibrary = true
    }
  }

  buildTypes {
    release {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),
        "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
  }
  kotlinOptions {
    jvmTarget = Versions.jvm
  }
  buildFeatures {
    compose = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = Versions.compose
  }
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
  applicationVariants.all {
    kotlin.sourceSets {
      getByName(name) {
        kotlin.srcDir("build/generated/ksp/$name/kotlin")
      }
    }
  }
}

dependencies {

  implementation("androidx.core:core-ktx:1.7.0")
  implementation("androidx.compose.ui:ui:${Versions.compose}")
  implementation("androidx.compose.material:material:${Versions.compose}")
  implementation("androidx.compose.ui:ui-tooling-preview:${Versions.compose}")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.1")
  implementation("androidx.activity:activity-compose:1.4.0")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
  androidTestImplementation(
    "androidx.compose.ui:ui-test-junit4:${Versions.compose}")
  debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose}")
  debugImplementation(
    "androidx.compose.ui:ui-test-manifest:${Versions.compose}")

  // hilt
  implementation(Deps.hiltAndroid)
  kapt(Deps.hiltCompiler)

  // navigation
  implementation(Deps.composeNavigationCore)
  ksp(Deps.composeNavigationKsp)

  // data layer
  implementation(project(":lib_tasks"))
}