package plugins

val ktlint: Configuration by configurations.creating

tasks {
    register<JavaExec>("ktlint") {
        group = "verification"
        description = "Check Kotlin code style."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args("--android", "src/**/*.kt")
    }

    register<JavaExec>("ktlintFormat") {
        group = "formatting"
        description = "Fix Kotlin code style deviations."
        classpath = ktlint
        mainClass.set("com.pinterest.ktlint.Main")
        args("--android", "-F", "src/**/*.kt")
    }
}
