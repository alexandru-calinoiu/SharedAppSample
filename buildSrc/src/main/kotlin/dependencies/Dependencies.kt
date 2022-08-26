package dependencies

object Dependencies {
    const val MATERIAL = "com.google.android.material:material:1.6.1"

    object Coroutines {
        const val VERSION = "1.6.4"

        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:1.8.0"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.5.0"

        object Navigation {
            private const val VERSION = "2.5.0-rc01"

            const val UI = "androidx.navigation:navigation-ui-ktx:$VERSION"
            const val COMPOSE = "androidx.navigation:navigation-compose:$VERSION"
        }

        object Compose {
            const val VERSION = "1.3.0"
            private const val ACCOMPANIST_PAGER_VERSION = "0.20.0"
            private const val CONSTRAINTLAYOUT_VERSION = "1.0.0-rc02"

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

            const val PAGER = "com.google.accompanist:accompanist-pager:$ACCOMPANIST_PAGER_VERSION"

            const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout-compose:$CONSTRAINTLAYOUT_VERSION"
        }

        object Lifecycle {
            private const val VERSION = "2.5.1"

            const val VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
            // ViewModel utilities for Compose
            const val VIEWMODEL_COMPOSE = "androidx.lifecycle:lifecycle-viewmodel-compose:$VERSION"
            const val LIVEDATA = "androidx.lifecycle:lifecycle-livedata-ktx:$VERSION"
            // Lifecycles only (without ViewModel or LiveData)
            const val RUNTIME_KTX =  "androidx.lifecycle:lifecycle-runtime-ktx:$VERSION"
            // if using Java8, use the following instead of lifecycle-compiler
            const val COMMON_JAVA8 = "androidx.lifecycle:lifecycle-common-java8:$VERSION"
        }

    }
}