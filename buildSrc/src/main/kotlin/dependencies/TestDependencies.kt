package dependencies

object TestDependencies {
    const val JUNIT = "junit:junit:4.13.2"
    const val KOIN = "io.insert-koin:koin-test:${Dependencies.Koin.VERSION}"

    object Apollo {
        const val MOCK_SERVER = "com.apollographql.apollo3:apollo-mockserver:${Dependencies.Apollo.VERSION}"
    }

    object Kotlinx {
        object Coroutines {
            const val TEST = "org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4"
        }
    }

    // only used in tests to read response files
    object Suparnatural {
        private const val VERSION = "1.1.0"

        const val FS = "com.suparnatural.kotlin:fs:$VERSION"
    }
}