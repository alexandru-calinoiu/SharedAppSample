import extensions.addProductFlavours

plugins {
    plugin(BuildPlugins.androidLibrary)
}

android {
    addProductFlavours(this)
}

dependencies {
    implementation(project(BuildModules.Features.ProfileShared))
}