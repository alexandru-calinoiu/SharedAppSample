import extensions.addProductFlavours

plugins {
    plugin(BuildPlugins.androidLibrary)
}

android {
    addProductFlavours(this)
}
