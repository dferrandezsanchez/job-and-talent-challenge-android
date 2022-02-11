package dev.ferrandezdaniel.jobandtalentchallenge

import android.app.Application
import dev.ferrandezdaniel.jobandtalentchallenge.di.commonModule
import dev.ferrandezdaniel.jobandtalentchallenge.di.dataSourceModule
import dev.ferrandezdaniel.jobandtalentchallenge.di.repositoryModule
import dev.ferrandezdaniel.jobandtalentchallenge.di.serviceFactoryModule
import dev.ferrandezdaniel.jobandtalentchallenge.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    private val modules = listOf(
        commonModule,
        useCaseModule,
        repositoryModule,
        dataSourceModule,
        serviceFactoryModule,
    )

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(
                modules
            )
        }
    }
}
