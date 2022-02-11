package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.domain.features.restaurants.useCases.GetRestaurantsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { GetRestaurantsUseCase(get()) }
}
