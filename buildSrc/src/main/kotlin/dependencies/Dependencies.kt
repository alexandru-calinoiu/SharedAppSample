package dependencies

object Dependencies {
    const val MATERIAL = "com.google.android.material:material:1.6.1"

    object Result {
        private const val VERSION = "5.2.1"

        const val KMM = "com.github.kittinunf.result:result:$VERSION"
        const val ANDROID = "com.github.kittinunf.result:result-jvm:$VERSION"
    }

    object Kotlinx {
        const val DATE_TIME = "org.jetbrains.kotlinx:kotlinx-datetime:0.4.0"

        object Coroutines {
            private const val VERSION = "1.6.4"

            const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
            const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
        }
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:1.8.0"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.5.0"
        const val CUSTOM_VIEW_POOLINGCONTAINER = "androidx.customview:customview-poolingcontainer:1.0.0"

        object Paging {
            private const val VERSION = "3.1.1"

            const val RUNTIME = "androidx.paging:paging-runtime:$VERSION"
        }

        object Navigation {
            private const val VERSION = "2.5.0-rc01"

            const val UI = "androidx.navigation:navigation-ui-ktx:$VERSION"
            const val COMPOSE = "androidx.navigation:navigation-compose:$VERSION"
        }

        object Compose {
            const val VERSION = "1.3.2"

            const val UI = "androidx.compose.ui:ui:1.2.1"

            // Tooling support (Previews, etc.)
            const val UI_TOOLING = "androidx.compose.ui:ui-tooling:1.2.1"

            // Foundation (Border, Background, Box, Image, Scroll, shapes, animations, etc.)
            const val FOUNDATION = "androidx.compose.foundation:foundation:1.2.1"

            // Material Design
            const val MATERIAL = "androidx.compose.material:material:1.2.1"

            // Material design icons
            const val MATERIAL_ICONS = "androidx.compose.material:material-icons-core:1.2.1"
            const val MATERIAL_ICONS_EXTENDED = "androidx.compose.material:material-icons-extended:1.2.1"

            // Integration with activities
            const val ACTIVITY = "androidx.activity:activity-compose:1.5.1"

            // Integration with observables
            const val LIVEDATA = "androidx.compose.runtime:runtime-livedata:1.2.1"

            const val PAGING = "androidx.paging:paging-compose:1.0.0-alpha16"
        }

        object Lifecycle {
            private const val VERSION = "2.5.1"

            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
            const val VIEWMODEL_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:$VERSION"
            const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
            // Lifecycles only (without ViewModel or LiveData)
            const val RUNTIME_KTX =  "androidx.lifecycle:lifecycle-runtime-ktx:$VERSION"
        }
    }

    object Apollo {
        const val VERSION = "3.6.0"

        const val RUNTIME = "com.apollographql.apollo3:apollo-runtime:$VERSION"
        const val ADAPTERS = "com.apollographql.apollo3:apollo-adapters:$VERSION"
    }

    object Koin {
        const val VERSION = "3.2.0"

        const val CORE = "io.insert-koin:koin-core:$VERSION"
        const val ANDROID = "io.insert-koin:koin-android:$VERSION"
        const val COMPOSE = "io.insert-koin:koin-androidx-compose:$VERSION"
    }

    object Coil {
        private const val VERSION = "2.2.1"

        const val COMPOSE = "io.coil-kt:coil-compose:$VERSION"
    }
}