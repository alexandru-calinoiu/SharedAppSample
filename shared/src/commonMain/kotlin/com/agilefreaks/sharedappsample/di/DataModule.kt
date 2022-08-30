package com.agilefreaks.sharedappsample.di

import com.agilefreaks.sharedappsample.Properties
import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.http.HttpRequest
import com.apollographql.apollo3.api.http.HttpResponse
import com.apollographql.apollo3.network.http.HttpInterceptor
import com.apollographql.apollo3.network.http.HttpInterceptorChain
import org.koin.dsl.module

val dataModule = module {
    single {
        val token = getProperty<String>("token")
        ApolloClient.Builder()
            .serverUrl(getProperty(Properties.SERVER_URL))
            .addHttpInterceptor(object : HttpInterceptor {
                override suspend fun intercept(
                    request: HttpRequest,
                    chain: HttpInterceptorChain
                ): HttpResponse = chain.proceed(
                    request.newBuilder().addHeader("Authorization", "Bearer $token").build()
                )
            })
            .build()
    }
}