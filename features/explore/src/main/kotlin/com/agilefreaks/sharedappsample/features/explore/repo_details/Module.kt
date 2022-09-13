package com.agilefreaks.sharedappsample.features.explore.repo_details

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val repoDetailsModule = module {
    viewModel { ViewModel() }
}