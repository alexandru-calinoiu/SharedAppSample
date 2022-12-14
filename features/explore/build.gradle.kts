import extensions.addProductFlavours

plugins {
    plugin(BuildPlugins.androidLibrary)
}

android {
    addProductFlavours(this)
}

dependencies {
    implementation(project(BuildModules.UI))
    implementation(project(BuildModules.Features.ExploreShared))
}
