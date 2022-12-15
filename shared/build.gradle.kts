import dependencies.Dependencies

plugins {
    plugin(BuildPlugins.sharedLibrary)
    plugin(BuildPlugins.apollo)
}

kotlin {
    cocoapods {
        summary = "Shared"
        homepage = "https://github.com/alexandru-calinoiu/SharedAppSample"
        ios.deploymentTarget = BuildiOSConfig.DEPLOYMENT_TARGET
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "Shared"
            isStatic = false
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(Dependencies.Apollo.RUNTIME)
                implementation(Dependencies.Apollo.ADAPTERS)
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Dependencies.AndroidX.Lifecycle.VIEWMODEL)
                implementation(Dependencies.AndroidX.Lifecycle.VIEWMODEL_COMPOSE)
                implementation(Dependencies.AndroidX.Lifecycle.LIVEDATA)
                implementation(Dependencies.AndroidX.Lifecycle.RUNTIME_KTX)
            }
        }
    }
}

android {
    namespace = "com.agilefreaks.sharedappsample"
}

apollo {
    service("github") {
        packageName.set("com.agilefreaks.sharedappsample.dtos")
        generateApolloMetadata.set(true)
        mapScalar("DateTime", "kotlinx.datetime.Instant", "com.apollographql.apollo3.adapter.KotlinxInstantAdapter")
    }
}
