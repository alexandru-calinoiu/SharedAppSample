package com.agilefreaks.sharedappsample

data class PagedResponse<U>(val pageInfo: PageInfo, val response: List<U>)

fun <U> emptyPagedResponse() : PagedResponse<U> = PagedResponse(emptyPageInfo(), emptyList())