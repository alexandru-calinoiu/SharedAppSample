package com.agilefreaks.sharedappsample.features.explore_shared

import com.agilefreaks.sharedappsample.features.explore_shared.repo_details.repoDetailsSharedModule
import com.agilefreaks.sharedappsample.features.explore_shared.repo_list.repoListSharedModule
import org.koin.core.module.Module

fun modules(): List<Module> = listOf(repoListSharedModule, repoDetailsSharedModule)