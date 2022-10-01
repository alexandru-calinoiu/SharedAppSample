package com.agilefreaks.sharedappsample.features.explore_shared.repo_details

import org.koin.dsl.module

val repoDetailsSharedModule = module {
    single { RepoDetailsRepository(get()) }
}