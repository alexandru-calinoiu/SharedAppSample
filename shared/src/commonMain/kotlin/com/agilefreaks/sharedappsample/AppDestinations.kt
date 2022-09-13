package com.agilefreaks.sharedappsample

object AppDestinations {
    open class Screen(val route: String)

    object Features {
        const val explore = "explore"

        const val profile = "profile"
    }

    object Explore {
        abstract class ExploreScreen(route: String) : Screen(route)

        abstract class DetailsScreen(route: String) : Screen(route)

        object Landing : ExploreScreen("landing")

        object Details : DetailsScreen("details")
    }

    object Profile {
        abstract class ProfileScreen(route: String) : Screen(route)

        object Landing : ProfileScreen("landing")
    }
}