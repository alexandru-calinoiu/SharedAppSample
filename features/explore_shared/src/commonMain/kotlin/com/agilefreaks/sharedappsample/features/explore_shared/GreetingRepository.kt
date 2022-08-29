package com.agilefreaks.sharedappsample.features.explore_shared

class GreetingRepository {
    fun greeting(): String {
        return "Explore shared module, ${Platform().platform}!"
    }
}