package dev.ferrandezdaniel.domain.features.restaurants

import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response

interface IRestaurantsRepository {
    suspend fun getRestaurants(): Response<List<Restaurant>>
}
