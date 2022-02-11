package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.data.features.restaurants.RestaurantsDataSource
import org.koin.dsl.module

val dataSourceModule = module {

    single { RestaurantsDataSource(get()) }
}
