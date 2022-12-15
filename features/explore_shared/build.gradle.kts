import dependencies.Dependencies

plugins {
    plugin(BuildPlugins.sharedLibrary)
    plugin(BuildPlugins.apollo)
}

dependencies {
    apolloMetadata(project(BuildModules.Shared))
}

kotlin {
    cocoapods {
        summary = "Stuff related to user github repositories"
        homepage = "https://github.com/alexandru-calinoiu/SharedAppSample"
        ios.deploymentTarget = BuildiOSConfig.DEPLOYMENT_TARGET
        podfile = project.file("../../iosApp/Podfile")
        framework {
            baseName = "ExploreShared"
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(BuildModules.Shared))
                
                implementation(Dependencies.Apollo.RUNTIME)
                implementation(Dependencies.Apollo.ADAPTERS)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.AndroidX.Navigation.COMPOSE)
                implementation(Dependencies.AndroidX.Paging.RUNTIME)
            }
        }
    }
}

android {
    namespace = "com.agilefreaks.sharedappsample.features.explore_shared"
}

apollo {
    service("github") {
        packageName.set("com.agilefreaks.sharedappsample.features.explore.dtos")
    }
}
