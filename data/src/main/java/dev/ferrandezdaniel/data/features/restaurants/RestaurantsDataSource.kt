package dev.ferrandezdaniel.data.features.restaurants

import dev.ferrandezdaniel.data.core.restaurants.IRestaurantsApi
import dev.ferrandezdaniel.data.core.restaurants.RestaurantsServiceFactory
import dev.ferrandezdaniel.data.core.restaurants.transform
import dev.ferrandezdaniel.domain.core.models.restaurants.Restaurant
import dev.ferrandezdaniel.domain.core.result.Response

class RestaurantsDataSource(
    private val restaurantsServiceFactory: RestaurantsServiceFactory
) {

    @Suppress("TooGenericExceptionCaught")
    suspend fun getRestaurants(): Response<List<Restaurant>> {
        return try {
            val restaurants =
                restaurantsServiceFactory.getRestaurantsService(IRestaurantsApi::class.java)
                    .getRestaurants()
            when {
                restaurants.isSuccessful && restaurants.body() != null -> Response.Success(
                    value = restaurants.body()!!.map { it.transform() }
                )
                else -> Response.Failure(exception = Exception())
            }
        } catch (e: Exception) {
            Response.Failure(exception = e)
        }
    }
}
