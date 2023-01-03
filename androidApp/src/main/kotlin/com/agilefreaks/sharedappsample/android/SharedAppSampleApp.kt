package com.agilefreaks.sharedappsample.android

import android.app.Application
import com.agilefreaks.sharedappsample.Properties
import com.agilefreaks.sharedappsample.di.dataModule
import com.agilefreaks.sharedappsample.features.explore.exploreModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import org.koin.fileProperties

class SharedAppSampleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SharedAppSampleApp)
            androidLogger()
            modules(dataModule + exploreModules())
            fileProperties()
            properties(mapOf(Properties.SERVER_URL to BuildConfig.API_BASE_URL))
        }
    }
}
