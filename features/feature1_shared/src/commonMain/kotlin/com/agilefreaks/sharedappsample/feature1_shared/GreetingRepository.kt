package com.agilefreaks.sharedappsample.feature1_shared

class GreetingRepository {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}