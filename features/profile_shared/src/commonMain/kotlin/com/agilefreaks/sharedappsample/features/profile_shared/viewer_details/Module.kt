package com.agilefreaks.sharedappsample.features.profile_shared.viewer_details

import org.koin.dsl.module

val userDetailsSharedModule = module {
    single { ViewerDetailsRepository(get()) }
}