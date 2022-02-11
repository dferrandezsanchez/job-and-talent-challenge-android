package dev.ferrandezdaniel.data.features.restaurants

import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response
import dev.ferrandezdaniel.domain.features.restaurants.IRestaurantsRepository

class RestaurantsRepository(
    private val restaurantsDataSource: RestaurantsDataSource
) : IRestaurantsRepository {
    override suspend fun getRestaurants(): Response<List<Restaurant>> =
        restaurantsDataSource.getRestaurants()
}
