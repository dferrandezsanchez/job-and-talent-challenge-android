package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.data.core.restaurants.RestaurantsServiceFactory
import org.koin.core.qualifier.named
import org.koin.dsl.module

val serviceFactoryModule = module {
    single {
        RestaurantsServiceFactory(
            get(named(DEBUG_PATH)),
            get(named(BASE_URL)),
            get(named(TIMEOUT))
        )
    }
}
