package dev.ferrandezdaniel.jobandtalentchallenge.di

import dev.ferrandezdaniel.jobandtalentchallenge.ui.features.details.DetailsViewModel
import dev.ferrandezdaniel.jobandtalentchallenge.ui.features.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { ListViewModel(get()) }
    viewModel { DetailsViewModel() }
}
