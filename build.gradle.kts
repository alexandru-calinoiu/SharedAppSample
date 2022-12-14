import io.gitlab.arturbosch.detekt.Detekt

plugins {
    plugin(BuildPlugins.updateDependencies)
    plugin(BuildPlugins.detekt)
}

tasks {
    val clean by registering(Delete::class) {
        delete(rootProject.buildDir)
    }
}

allprojects {
    apply(plugin = BuildPlugins.detekt.id)

    dependencies {
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.22.0")
    }

    tasks {
        withType<Detekt> {
            autoCorrect = true
        }

        named<Detekt>("detekt").configure {
            reports {
                xml {
                    required.set(true)
                    outputLocation.set(project.file("build/reports/detekt/report.xml"))
                }
                html {
                    required.set(true)
                    outputLocation.set(project.file("build/reports/detekt/report.html"))
                }
            }
        }
    }
}
