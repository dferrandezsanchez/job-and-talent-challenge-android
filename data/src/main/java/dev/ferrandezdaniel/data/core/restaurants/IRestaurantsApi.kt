package dev.ferrandezdaniel.data.core.restaurants

import retrofit2.Response
import retrofit2.http.GET

interface IRestaurantsApi {

    companion object {
        private const val PATH_GET_PLACE =
            "/api/restaurant/random_restaurant?size=100"
    }

    @GET(PATH_GET_PLACE)
    suspend fun getRestaurants(): Response<List<RestaurantDto>>
}
