package com.agilefreaks.sharedappsample

object AppDestinations {
    open class Screen(val route: String)

    object Features {
        const val explore = "explore"

        const val profile = "profile"
    }

    object Profile {
        abstract class ProfileScreen(route: String) : Screen(route)

        object Landing : ProfileScreen("landing")
    }
}