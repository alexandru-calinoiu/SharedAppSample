package commons

import dependencies.Dependencies
import dependencies.TestAndroidDependencies
import dependencies.TestDependencies

plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION

    defaultConfig {
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    buildFeatures {
        compose = true
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    lint {
        lintConfig = rootProject.file(".lint/config.xml")
        checkAllWarnings = true
        warningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.AndroidX.Compose.VERSION
    }
}

dependencies {
    implementation(project(BuildModules.Shared))

    implementation(Dependencies.Result.ANDROID)

    implementation(Dependencies.Koin.ANDROID)
    implementation(Dependencies.Koin.COMPOSE)

    implementation(Dependencies.Kotlinx.Coroutines.CORE)
    implementation(Dependencies.Kotlinx.Coroutines.ANDROID)

    implementation(Dependencies.AndroidX.CORE)
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.AndroidX.Paging.RUNTIME)
    implementation(Dependencies.MATERIAL)

    implementation(Dependencies.AndroidX.Compose.FOUNDATION)
    implementation(Dependencies.AndroidX.Compose.UI)
    implementation(Dependencies.AndroidX.Compose.PAGING)
    implementation(Dependencies.AndroidX.Compose.UI_TOOLING)
    implementation(Dependencies.AndroidX.Compose.MATERIAL)
    implementation(Dependencies.AndroidX.Compose.MATERIAL_ICONS)
    implementation(Dependencies.AndroidX.Compose.MATERIAL_ICONS_EXTENDED)
    implementation(Dependencies.AndroidX.Compose.ACTIVITY)

    implementation(Dependencies.AndroidX.Navigation.COMPOSE)
    implementation(Dependencies.AndroidX.Navigation.UI)

    debugImplementation(Dependencies.AndroidX.CUSTOM_VIEW_POOLINGCONTAINER)

    testImplementation(TestDependencies.JUNIT)

    androidTestImplementation(TestAndroidDependencies.AndroidX.JUNIT)
    androidTestImplementation(TestAndroidDependencies.AndroidX.ESPRESSO_CORE)
}
