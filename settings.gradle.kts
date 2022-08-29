pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "SharedAppSample"
include(
    ":androidApp",
    ":features:explore", ":features:explore_shared",
    ":features:profile", ":features:profile_shared"
)
include(":shared")
