object BuildPlugins {
    val androidApplication = GradlePlugin(id = "com.android.application")
    val androidLibrary = GradlePlugin(id = "commons.android-library")
    val sharedLibrary = GradlePlugin(id = "commons.shared-library")

    val kotlinAndroid = GradlePlugin(id = "kotlin-android")
    val kotlinKapt = GradlePlugin(id = "kotlin-kapt")

    val apollo = GradlePlugin(id = "com.apollographql.apollo3", version = dependencies.Dependencies.Apollo.VERSION)

    val detekt = GradlePlugin("plugins.detekt")
    val updateDependencies = GradlePlugin(id = "plugins.update-dependencies")
}
