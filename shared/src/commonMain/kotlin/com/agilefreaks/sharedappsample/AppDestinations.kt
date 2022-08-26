package com.agilefreaks.sharedappsample

object AppDestinations {
    open class Screen(val route: String)

    object Features {
        const val feature1 = "feature1"

        const val feature2 = "feature2"
    }

    object Feature1 {
        abstract class Feature1Screen(route: String) : Screen(route)

        object Landing : Feature1Screen("landing")
    }

    object Feature2 {
        abstract class Feature2Screen(route: String) : Screen(route)

        object Landing : Feature2Screen("landing")
    }
}