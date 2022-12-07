object BuildPlugins {
    val androidApplication = GradlePlugin(id = "com.android.application")
    val androidLibrary = GradlePlugin(id = "commons.android-library")
    val sharedLibrary = GradlePlugin(id = "commons.shared-library")

    val kotlinAndroid = GradlePlugin(id = "kotlin-android")
    val kotlinKapt = GradlePlugin(id = "kotlin-kapt")

    val apollo = GradlePlugin(id = "com.apollographql.apollo3", version = dependencies.Dependencies.Apollo.VERSION)

    const val GPP = "plugins.gpp"
    const val DETEKT = "plugins.detekt"
    const val KTLINT = "plugins.ktlint"
    const val SPOTLESS = "plugins.spotless"
    val updateDependencies = GradlePlugin(id = "plugins.update-dependencies")

    const val GOOGLE_SERVICES = "com.google.gms.google-services"
    const val FIREBASE_CRASHLYTICS = "com.google.firebase.crashlytics"
    const val FIREBASE_PERFORMANCE = "com.google.firebase.firebase-perf"
}