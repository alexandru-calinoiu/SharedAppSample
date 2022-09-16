import dependencies.Dependencies

plugins {
    id("commons.shared-library")
    id("com.apollographql.apollo3").version(dependencies.Dependencies.Apollo.VERSION)
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
            }
        }
    }
}

apollo {
    packageName.set("com.agilefreaks.sharedappsample.features.explore.dtos")
}