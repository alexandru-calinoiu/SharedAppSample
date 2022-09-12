package com.agilefreaks.sharedappsample

data class PageInfo(
    val endCursor: String?,
    val hasNextPage: Boolean,
)

fun emptyPageInfo() = PageInfo(
    endCursor = null,
    hasNextPage = false,
)