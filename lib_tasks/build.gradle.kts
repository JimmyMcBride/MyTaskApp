plugins {
  id("com.android.library")
  id("org.jetbrains.kotlin.android")
  id("dagger.hilt.android.plugin")
  id("kotlin-kapt")
}

android {
  compileSdk = 31

  defaultConfig {
    minSdk = 21
    targetSdk = 32

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
  packagingOptions {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {

  implementation(Deps.hiltAndroid)
  kapt(Deps.hiltCompiler)
  implementation(Deps.coroutinesCore)
  implementation(Deps.datastorePreferences)
}