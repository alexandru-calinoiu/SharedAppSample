plugins {
    id("commons.shared-library")
}

kotlin {
    cocoapods {
        summary = "Stuff related to user github repositories"
        homepage = "https://github.com/alexandru-calinoiu/SharedAppSample"
        ios.deploymentTarget = "14.1"
        framework {
            baseName = "explore_shared"
        }
    }
}
