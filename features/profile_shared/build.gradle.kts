plugins {
    plugin(BuildPlugins.sharedLibrary)
}

kotlin {
    cocoapods {
        summary = "Stuff related to the user profile"
        homepage = "https://github.com/alexandru-calinoiu/SharedAppSample"
        ios.deploymentTarget = BuildiOSConfig.DEPLOYMENT_TARGET
        podfile = project.file("../../iosApp/Podfile")
        framework {
            baseName = "ProfileShared"
        }
    }
    
    sourceSets {
        val commonMain by getting
        val androidMain by getting
    }
}

android {
    namespace = "com.agilefreaks.sharedappsample.features.profile_shared"
}
