package com.agilefreaks.sharedappsample.features.explore_shared.repo_list

import com.agilefreaks.sharedappsample.PageInfo
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
import kotlin.test.*

@OptIn(ApolloExperimental::class, ExperimentalCoroutinesApi::class)
class ViewerRepositoryTest : KoinTest {
    private lateinit var mockServer: MockServer
    private val viewerRepository by lazy {
        get<ViewerRepository>()
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
    fun `repos will return the firs 10 repositories`(): Unit = runBlocking {
        mockServer.enqueue("viewer_repository_response.json".readResponseContent())
        val (value, _) = viewerRepository.repos()

        assertEquals(value?.response?.size, 10)
    }

    @Test
    fun `repos will populate page info`(): Unit = runBlocking {
        mockServer.enqueue("viewer_repository_response.json".readResponseContent())
        val (value, _) = viewerRepository.repos()

        assertEquals(value?.pageInfo, PageInfo(
            endCursor = "Y3Vyc29yOnYyOpHOADURPg==",
            hasNextPage = true
        ))
    }

    private fun String.readResponseContent() = FileSystem.readFile("responses/repo_list/$this")?.commonToUtf8String() ?: ""
}