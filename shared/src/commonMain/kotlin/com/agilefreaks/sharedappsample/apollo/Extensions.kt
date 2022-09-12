package com.agilefreaks.sharedappsample.apollo

import com.apollographql.apollo3.api.Optional

fun Int.toOptional() = Optional.presentIfNotNull(this)

fun String?.toOptional() = Optional.presentIfNotNull(this)