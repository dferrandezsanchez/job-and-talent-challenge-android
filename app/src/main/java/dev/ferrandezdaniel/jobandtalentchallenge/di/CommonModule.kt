package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.jobandtalentchallenge.BuildConfig
import org.koin.core.qualifier.named
import org.koin.dsl.module

const val DEBUG_PATH = "dev.ferrandezdaniel.jobandtalentchallenge.di.DEBUG_PATH"
const val BASE_URL = "dev.ferrandezdaniel.jobandtalentchallenge.di.BASE_URL"
const val TIMEOUT = "dev.ferrandezdaniel.jobandtalentchallenge.di.TIMEOUT"

val commonModule = module {
    single(named(DEBUG_PATH)) { BuildConfig.DEBUG }
    single(named(BASE_URL)) { BuildConfig.BASE_URL }
    single(named(TIMEOUT)) { BuildConfig.TIMEOUT }
}
