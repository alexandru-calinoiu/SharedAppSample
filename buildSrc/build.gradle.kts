plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
}

object PluginsVersions {
    const val GRADLE_ANDROID = "7.3.1"
    const val KOTLIN = "1.7.22"

    const val KTLINT = "0.36.0"
    const val DETEKT = "1.2.2"
    const val UPDATE_VERSIONS = "0.44.0"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginsVersions.GRADLE_ANDROID}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginsVersions.KOTLIN}")
    implementation("com.pinterest:ktlint:${PluginsVersions.KTLINT}")
    implementation("io.gitlab.arturbosch.detekt:detekt-gradle-plugin:${PluginsVersions.DETEKT}")
    implementation("com.github.ben-manes:gradle-versions-plugin:${PluginsVersions.UPDATE_VERSIONS}")
}