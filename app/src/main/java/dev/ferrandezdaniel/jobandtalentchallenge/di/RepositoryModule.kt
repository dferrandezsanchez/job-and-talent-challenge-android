package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.data.features.restaurants.RestaurantsRepository
import dev.ferrandezdaniel.domain.features.restaurants.IRestaurantsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<IRestaurantsRepository> { RestaurantsRepository(get()) }
}
