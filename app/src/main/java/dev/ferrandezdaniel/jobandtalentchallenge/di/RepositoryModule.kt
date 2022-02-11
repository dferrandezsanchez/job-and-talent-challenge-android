package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.data.features.restaurants.RestaurantsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { RestaurantsRepository(get()) }
}
