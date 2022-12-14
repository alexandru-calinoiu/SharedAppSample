package com.agilefreaks.sharedappsample.features.explore.repo_list

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoListModule = module {
    viewModel { ViewModel(get()) }
}
