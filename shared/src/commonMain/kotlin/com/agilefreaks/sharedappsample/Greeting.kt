package com.agilefreaks.sharedappsample

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}