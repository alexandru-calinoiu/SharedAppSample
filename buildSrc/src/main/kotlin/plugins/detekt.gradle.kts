package plugins

import io.gitlab.arturbosch.detekt.DetektPlugin
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

apply<DetektPlugin>()

configure<DetektExtension> {
    source = project.files("src/main/kotlin")
    config = files("$rootDir/.detekt/config.yml")
}
