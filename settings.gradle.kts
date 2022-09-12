pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SharedAppSample"
include(
    ":androidApp",
    ":ui",
    ":features:explore", ":features:explore_shared",
    ":features:profile", ":features:profile_shared"
)
include(":shared")
