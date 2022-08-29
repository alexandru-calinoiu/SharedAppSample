package com.agilefreaks.sharedappsample.features.explore_shared

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        assertTrue(GreetingRepository().greeting().contains("Hello"), "Check 'Hello' is mentioned")
    }
}