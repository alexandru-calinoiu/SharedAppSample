plugins {
    plugin(BuildPlugins.updateDependencies)
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
    }
}