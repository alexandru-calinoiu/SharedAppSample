package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import org.koin.dsl.module

val repoListSharedModule = module {
    single<ViewerRepository> { ViewerRepositoryImpl(get()) }
}