import dependencies.Dependencies
import dependencies.TestDependencies
import dependencies.TestAndroidDependencies
import extensions.addProductFlavours

plugins {
    plugin(BuildPlugins.androidApplication)
    plugin(BuildPlugins.kotlinAndroid)
    plugin(BuildPlugins.kotlinKapt)
}

android {
    compileSdk = BuildAndroidConfig.COMPILE_SDK_VERSION
    namespace = "com.agilefreaks.sharedappsample.android"

    defaultConfig {
        applicationId = BuildAndroidConfig.APPLICATION_ID
        minSdk = BuildAndroidConfig.MIN_SDK_VERSION
        targetSdk = BuildAndroidConfig.TARGET_SDK_VERSION

        versionCode = BuildAndroidConfig.VERSION_CODE
        versionName = BuildAndroidConfig.VERSION_NAME

        testInstrumentationRunner = BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER
        testInstrumentationRunnerArguments.putAll(BuildAndroidConfig.TEST_INSTRUMENTATION_RUNNER_ARGUMENTS)
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
        }
        getByName(BuildType.DEBUG) {
            signingConfig = signingConfigs.getByName(BuildType.DEBUG)
            applicationIdSuffix = BuildTypeDebug.applicationIdSuffix
            versionNameSuffix = BuildTypeDebug.versionNameSuffix
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
        }
    }

    addProductFlavours(this)

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
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

    composeOptions {
        kotlinCompilerExtensionVersion  = Dependencies.AndroidX.Compose.VERSION
    }
}

dependencies {
    implementation(project(BuildModules.Shared))
    implementation(project(BuildModules.Features.Explore))

    implementation(Dependencies.Koin.CORE)
    implementation(Dependencies.Koin.ANDROID)

    implementation(Dependencies.Kotlinx.Coroutines.CORE)
    implementation(Dependencies.Kotlinx.Coroutines.ANDROID)

    implementation(Dependencies.AndroidX.CORE)
    implementation(Dependencies.AndroidX.APPCOMPAT)
    implementation(Dependencies.MATERIAL)

    implementation(Dependencies.AndroidX.Compose.FOUNDATION)
    implementation(Dependencies.AndroidX.Compose.UI)
    implementation(Dependencies.AndroidX.Compose.UI_TOOLING)
    implementation(Dependencies.AndroidX.Compose.MATERIAL)
    implementation(Dependencies.AndroidX.Compose.MATERIAL_ICONS)
    implementation(Dependencies.AndroidX.Compose.MATERIAL_ICONS_EXTENDED)
    implementation(Dependencies.AndroidX.Compose.ACTIVITY)

    implementation(Dependencies.AndroidX.Navigation.COMPOSE)
    implementation(Dependencies.AndroidX.Navigation.UI)

    testImplementation(TestDependencies.JUNIT)
    testImplementation(TestDependencies.KOIN)

    androidTestImplementation(TestAndroidDependencies.AndroidX.JUNIT)
    androidTestImplementation(TestAndroidDependencies.AndroidX.ESPRESSO_CORE)
}
