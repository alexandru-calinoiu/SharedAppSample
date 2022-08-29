package com.agilefreaks.sharedappsample.features.profile_shared

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}