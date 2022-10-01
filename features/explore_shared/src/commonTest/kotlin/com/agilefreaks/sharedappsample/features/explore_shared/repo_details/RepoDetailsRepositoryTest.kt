package com.agilefreaks.sharedappsample.features.explore_shared.repo_details

import com.agilefreaks.sharedappsample.Properties
import com.agilefreaks.sharedappsample.di.dataModule
import com.apollographql.apollo3.annotations.ApolloExperimental
import com.apollographql.apollo3.mockserver.MockServer
import com.apollographql.apollo3.mockserver.enqueue
import com.suparnatural.core.fs.FileSystem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import okio.internal.commonToUtf8String
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ApolloExperimental::class, ExperimentalCoroutinesApi::class)
class RepoDetailsRepositoryTest : KoinTest {
    private lateinit var mockServer: MockServer
    private val repoDetailsRepository by lazy {
        get<RepoDetailsRepository>()
    }

    @BeforeTest
    fun setUp() {
        Dispatchers.setMain(StandardTestDispatcher())
        runBlocking {
            mockServer = MockServer()
            val mockServerUrl = mockServer.url()

            startKoin {
                modules(dataModule + com.agilefreaks.sharedappsample.features.explore_shared.modules())
                properties(
                    mapOf(
                        Properties.SERVER_URL to mockServerUrl,
                        Properties.TOKEN to "token"
                    )
                )
            }
        }
    }

    @AfterTest
    fun tearDown() = runBlocking {
        Dispatchers.resetMain()
        mockServer.stop()
        stopKoin()
    }

    @Test
    fun `repoDetails will return the correct repo name`(): Unit = runBlocking {
        mockServer.enqueue("repo_details_repository_response.json".readResponseContent())
        val (value, _) = repoDetailsRepository.repoDetails("alexandru-calinoiu", "SharedAppSample")

        assertEquals(value?.name, "SharedAppSample")
    }

    @Test
    fun `repoDetails will return the correct fork count`(): Unit = runBlocking {
        mockServer.enqueue("repo_details_repository_response.json".readResponseContent())
        val (value, _) = repoDetailsRepository.repoDetails("alexandru-calinoiu", "SharedAppSample")

        assertEquals(value?.forkCount, 1)
    }

    @Test
    fun `repoDetails will return all the labels`(): Unit = runBlocking {
        mockServer.enqueue("repo_details_repository_response.json".readResponseContent())
        val (value, _) = repoDetailsRepository.repoDetails("alexandru-calinoiu", "SharedAppSample")

        assertEquals(value?.labels?.count(), 9)
    }


    private fun String.readResponseContent() =
        FileSystem.readFile("responses/repo_list/$this")?.commonToUtf8String() ?: ""
}