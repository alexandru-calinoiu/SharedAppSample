package dependencies

object Dependencies {
    const val MATERIAL = "com.google.android.material:material:1.6.1"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.4"

    object Coroutines {
        const val VERSION = "1.6.4"

        const val CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
    }

    object AndroidX {
        const val CORE = "androidx.core:core-ktx:1.8.0"
        const val APPCOMPAT = "androidx.appcompat:appcompat:1.5.0"

        object Compose {
            const val VERSION = "1.3.0"

            // Integration with observables
            const val LIVEDATA = "androidx.compose.runtime:runtime-livedata:1.2.1"
        }
    }
}