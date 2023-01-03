import extensions.addProductFlavours

plugins {
    plugin(BuildPlugins.androidLibrary)
}

android {
    addProductFlavours(this)

    namespace = "com.agilefreaks.sharedappsample.features.explore"
}

dependencies {
    implementation(project(BuildModules.UI))
    implementation(project(BuildModules.Features.ExploreShared))
}
